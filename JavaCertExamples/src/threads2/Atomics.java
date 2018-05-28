package threads2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Atomics {

  private int count = 0;

  private synchronized void incrementAndReport() {
    //synchronized ( this ) {
      System.out.println( ++count );
    //}
  }

  public static void main( String[] args ) {
    ExecutorService service = Executors.newFixedThreadPool( 20 );

    Atomics atomic = new Atomics();

    for ( int i = 0; i < 10; i++ ) {
      service.submit( () -> atomic.incrementAndReport() );
    }

    service.shutdown();

    System.out.println( "END RESULT: " + atomic.count );

  }

}
