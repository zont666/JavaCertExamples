package threads3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Question1 {

  public static void main( String[] args ) throws InterruptedException, ExecutionException {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    service.scheduleWithFixedDelay( () -> { // w1
      System.out.println( "Open Zoo" );
    }, 0, 1, TimeUnit.MINUTES );
    Future<?> result = service.submit( () -> System.out.println( "Wake Staff" ) ); // w3
    System.out.println( result.get() ); // w4

  }

}
