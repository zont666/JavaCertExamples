package enthuware.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ForkJoinPoolExample {

  public static void main( String[] args ) {
    ForkJoinPool pool = new ForkJoinPool();
    int[] values = IntStream.range( 0, 10000 ).toArray();

    pool.invoke( new ComplicatedAction( values, 0, 10000 - 1 ) );
    for ( int value : values ) {
      System.out.println( value );
    }

  }

  static class ComplicatedAction extends RecursiveAction {

    int[] ints;
    int from;
    int to;

    public ComplicatedAction( int[] ints, int from, int to ) {
      this.ints = ints;
      this.from = from;
      this.to = to;
    }

    @Override
    protected void compute() {
      System.out.println( Thread.currentThread().getName() + ": from - " + from + ", to - " + to );
      if ( from == to ) {
        System.out.println( "BEFORE: " + ints[from] );
        ints[from] = transformInteger( ints[from] );
        System.out.println( "AFTER: " + ints[from] );
      }
      else {
        int midpoint = (from + to) / 2;
        ComplicatedAction action1 = new ComplicatedAction( ints, from, midpoint );
        ComplicatedAction action2 = new ComplicatedAction( ints, midpoint + 1, to );
        invokeAll( action1, action2 );
      }

    }

    public int transformInteger( int initial ) {
      System.out.println( "Transforming " + initial );
      int transformed = initial * ThreadLocalRandom.current().nextInt( initial + 1 );
      System.out.println( "Transformed: " + transformed );
      return transformed;
    }

  }

}
