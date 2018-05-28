package threads2.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

public class WeighAnimalTask extends RecursiveTask<Double> {

  private int start;
  private int end;
  private Double[] weights;

  public WeighAnimalTask( Double[] weights, int start, int end ) {
    this.start = start;
    this.end = end;
    this.weights = weights;

  }

  @Override
  protected Double compute() {
    if ( (end - start) <= 3 ) {
      double sum = 0;
      for ( int i = start; i < end; i++ ) {
        weights[i] = ThreadLocalRandom.current().nextDouble( 100 );
        System.out.println( Thread.currentThread().getName() + " :: Animal weighed: " + i );
        sum += weights[i];
      }
      return sum;
    }
    else {
      int middle = start + ((end - start) / 2);
      System.out.println( Thread.currentThread().getName() + " :: [start=" + start + ",middle=" + middle + ",end=" + end + "]" );
      RecursiveTask<Double> otherTask = new WeighAnimalTask( weights, start, middle );
      otherTask.fork();
      return new WeighAnimalTask( weights, middle, end ).compute() + otherTask.join();
    }
  }
  
  public static void main( String[] args ) {
    Double[] weights = new Double[10000];
    ForkJoinTask<Double> task = new WeighAnimalTask( weights, 0, weights.length );
    ForkJoinPool pool = new ForkJoinPool();
    Double sum = pool.invoke( task );
    System.out.println( sum );
  }

}
