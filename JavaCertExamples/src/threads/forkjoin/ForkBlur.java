package threads.forkjoin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import javax.imageio.ImageIO;

public class ForkBlur extends RecursiveAction {
  private int[] mSource;
  private int mStart;
  private int mLength;
  private int[] mDestination;
  private int mBlurWidth = 15;

  protected static int sThreshold = 100000;

  public ForkBlur( int[] src, int start, int length, int[] dst ) {
    mSource = src;
    mStart = start;
    mLength = length;
    mDestination = dst;
  }

  protected void computeDirectly() {
    int sidePixels = (mBlurWidth - 1) / 2;
    for ( int index = mStart; index < mStart + mLength; index++ ) {
      // Calculate average.
      float rt = 0, gt = 0, bt = 0;
      for ( int mi = -sidePixels; mi <= sidePixels; mi++ ) {
        int mindex = Math.min( Math.max( mi + index, 0 ), mSource.length - 1 );
        int pixel = mSource[mindex];
        rt += (float)((pixel & 0x00ff0000) >> 16) / mBlurWidth;
        gt += (float)((pixel & 0x0000ff00) >> 8) / mBlurWidth;
        bt += (float)((pixel & 0x000000ff) >> 0) / mBlurWidth;
      }

      // Reassemble destination pixel.
      int dpixel = (0xff000000) | (((int)rt) << 16) | (((int)gt) << 8) | (((int)bt) << 0);
      mDestination[index] = dpixel;
    }

  }

  @Override
  protected void compute() {
    Thread currentThread = Thread.currentThread();
    System.out.format( "%s is currently running with a state of %s and priority of %s%n", currentThread.getName(), currentThread.getState().name(), currentThread.getPriority() );

    if ( mLength < sThreshold ) {
      System.out.println( "...computing directly" );
      computeDirectly();
      return;
    }

    System.out.println( "...breaking down into smaller chunks" );
    int split = mLength / 2;

    invokeAll( new ForkBlur( mSource, mStart, split, mDestination ), //
        new ForkBlur( mSource, mStart + split, mLength - split, mDestination ) );

  }

  public static void main( String[] args ) throws Exception {
    String srcName = "Koala.jpg";
    File srcFile = new File( srcName );
    BufferedImage image = ImageIO.read( srcFile );

    System.out.println( "Source image: " + srcName );

    BufferedImage blurredImage = blur( image );

    String dstName = "blurred-Koala.jpg";
    File dstFile = new File( dstName );
    ImageIO.write( blurredImage, "jpg", dstFile );

    System.out.println( "Output image: " + dstName );
  }

  public static BufferedImage blur( BufferedImage srcImage ) {
    int w = srcImage.getWidth();
    int h = srcImage.getHeight();

    int[] src = srcImage.getRGB( 0, 0, w, h, null, 0, w );
    int[] dst = new int[src.length];

    System.out.println( "Array size is " + src.length );
    System.out.println( "Threshold is " + sThreshold );

    int processors = Runtime.getRuntime().availableProcessors();

    System.out.println( Integer.toString( processors ) + " processor" + (processors != 1 ? "s are " : " is ") + "available" );

    ForkBlur forkBlur = new ForkBlur( src, 0, src.length, dst );

    ForkJoinPool forkJoinPool = new ForkJoinPool();

    long startTime = System.currentTimeMillis();
    forkJoinPool.invoke( forkBlur );
    long endTime = System.currentTimeMillis();

    System.out.println( "Image blur took " + (endTime - startTime) + " milliseconds" );

    BufferedImage dstImage = new BufferedImage( w, h, BufferedImage.TYPE_INT_ARGB );
    dstImage.setRGB( 0, 0, w, h, dst, 0, w );

    return dstImage;

  }

}
