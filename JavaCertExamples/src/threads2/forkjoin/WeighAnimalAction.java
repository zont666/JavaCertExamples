package threads2.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class WeighAnimalAction extends RecursiveAction {

  private int start;
  private int end;
  private Double[] weights;

  public WeighAnimalAction( Double[] weights, int start, int end ) {
    this.start = start;
    this.end = end;
    this.weights = weights;

  }

  @Override
  protected void compute() {
    if ( end - start <= 3 ) {
      for ( int i = start; i < end; i++ ) {
        weights[i] = (double)ThreadLocalRandom.current().nextInt( 100 );
        System.out.println( Thread.currentThread().getName() + " :: Animal weighed: " + i );
      }
    }
    else {
      int middle = start + ((end - start) / 2);
      System.out.println( Thread.currentThread().getName() + " :: [start=" + start + ",middle=" + middle + ",end=" + end + "]" );
      invokeAll( new WeighAnimalAction( weights, start, middle ), //
          new WeighAnimalAction( weights, middle, end ) );
    }
  }

  public static void main( String[] args ) {
    Double[] weights = new Double[100];

    ForkJoinTask<?> task = new WeighAnimalAction( weights, 0, weights.length );
    ForkJoinPool pool = new ForkJoinPool();
    long start = System.currentTimeMillis();
    pool.invoke( task );
    long end = System.currentTimeMillis();
    System.out.println( "\nProcess in " + (end - start) + " ms" );

    System.out.println();
    System.out.println( "Weights: " );
    Arrays.asList( weights ).stream() //
        .forEach( d -> System.out.println( d.intValue() ) );
  }

}
