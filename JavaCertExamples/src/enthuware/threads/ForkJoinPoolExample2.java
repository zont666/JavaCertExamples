package enthuware.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinPoolExample2 {

  public static void main( String[] args ) {
    ForkJoinPool pool = new ForkJoinPool();
    int[] values = IntStream.range( 0, 1000 ).toArray();

    pool.invoke( new ComplicatedTask( values, 0, 1000 - 1 ) );
    for ( int value : values ) {
      System.out.println( value );
    }

  }

  static class ComplicatedTask extends RecursiveTask<Integer> {

    int[] ints;
    int from;
    int to;
    static final int THRESHOLD = 3;

    public ComplicatedTask( int[] ints, int from, int to ) {
      this.ints = ints;
      this.from = from;
      this.to = to;
    }

    @Override
    protected Integer compute() {
      int sum = 0;
      if ( from + THRESHOLD > to ) {
        for ( int i = from; i <= to; i++ ) {
          sum = sum + ints[i];
        }
        return sum;
      }
      else {
        int mid = (from + to) / 2;
        ComplicatedTask newtask1 = new ComplicatedTask( ints, from, mid );
        ComplicatedTask newtask2 = new ComplicatedTask( ints, mid + 1, to );
        newtask1.fork();
        return newtask2.compute() + newtask1.join();
      }

    }

  }

}
