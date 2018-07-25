package threads.india;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableTest {
  private static AtomicInteger counter = new AtomicInteger( 0 );

  static class Decrementer extends Thread {
    @Override
    public void run() {
      System.out.printf( "Decrementing: %s executing, value currently at %d%n", Thread.currentThread().getName(), counter.decrementAndGet() );
    }
  }

  static class Incrementer extends Thread {
    @Override
    public void run() {
      System.out.printf( "Incrementing: %s executing, value currently at %d%n", Thread.currentThread().getName(), counter.incrementAndGet() );
    }
  }

  public static void main( String[] args ) {
    for ( int i = 0; i < 5; i++ ) {
      new Incrementer().start();
      new Decrementer().start();
    }
    System.out.println( counter );
  }

}
