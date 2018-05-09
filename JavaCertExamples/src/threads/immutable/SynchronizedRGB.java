package threads.immutable;

public class SynchronizedRGB {

  private int red, green, blue;
  private String name;

  private void check( int r, int g, int b ) {
    if ( r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255 ) {
      throw new IllegalArgumentException();
    }
  }

  public SynchronizedRGB( int red, int green, int blue, String name ) {
    check( red, green, blue );
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.name = name;
  }

  public void set( int red, int green, int blue, String name ) {
    System.out.println( Thread.currentThread().getName() + ": calling set" );
    check( red, green, blue );
    synchronized ( this ) {
      System.out.println( Thread.currentThread().getName() + ": inside set" );
      this.red = red;
      this.green = green;
      this.blue = blue;
      this.name = name;
    }
  }

  public synchronized int getRGB() {
    System.out.println( Thread.currentThread().getName() + ": getting RGB" );
    return ((red << 16) | (green << 8) | blue);
  }

  public synchronized String getName() {
    System.out.println( Thread.currentThread().getName() + ": getting colour name" );
    return name;
  }

  public synchronized void invert() {
    red = 255 - red;
    green = 255 - green;
    blue = 255 - blue;
    name = "Inverse of " + name;
  }

  public static void main( String[] args ) {
    SynchronizedRGB colour = new SynchronizedRGB( 0, 0, 0, "Pitch Black" );

    new Thread( new Runnable() {
      @Override
      public void run() {
        colour.set( 110, 244, 66, "Green" );
        System.out.format( Thread.currentThread().getName() + ": Colour of %s with an RGB value of %s%n", colour.getName(), colour.getRGB() );
      }
    }, "Green" ).start();

    int myColourInt = colour.getRGB();

    new Thread( new Runnable() {
      @Override
      public void run() {
        colour.set( 255, 255, 255, "White" );
        System.out.format( Thread.currentThread().getName() + ": Colour of %s with an RGB value of %s%n", colour.getName(), colour.getRGB() );
      }
    }, "White" ).start();

    String myColourName = colour.getName();

    System.out.format( Thread.currentThread().getName() + ": Colour of %s with an RGB value of %s%n", myColourName, myColourInt );

  }

}
