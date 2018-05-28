package threads2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Futures {

  private static int counter = 0;

  public static void main( String[] args ) throws InterruptedException, ExecutionException {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();

      Future<?> result = service.submit( () -> {
        for ( int i = 0; i < 500; i++ ) {
          Futures.counter++;
          System.out.println( counter );
        }
      } );

      result.get( 10, TimeUnit.SECONDS );

      System.out.println( "Reached!" );
      //result.cancel( true );

      //      System.out.println( result.isDone() );
      //      System.out.println( result.isCancelled() );
      //
      //
      //      System.out.println( result.isDone() );
      //      System.out.println( result.isCancelled() );
    }
    catch ( TimeoutException e ) {
      System.out.println( "Not reached in time" );
    }
    finally {
      if ( service != null )
        service.shutdown();
    }

  }

}
