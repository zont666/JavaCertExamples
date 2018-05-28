package threads2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitingForThreadsToFinish {

  public static void main( String[] args ) throws InterruptedException {
    ExecutorService service = null;
    try {
      service = Executors.newCachedThreadPool();
      for ( int i = 0; i < 100000; i++ ) {
        final int x = i;
        service.submit( () -> System.out.println( Thread.currentThread().getName() + " - " + x ) );
      }

    }
    finally {
      if ( service != null )
        service.shutdown();
    }

    if ( service != null ) {
      service.awaitTermination( 1, TimeUnit.SECONDS );
      if ( service.isTerminated() )
        System.out.println( "All tasks finished" );
      else
        System.out.println( "At least one task is still running" );
    }

  }

}
