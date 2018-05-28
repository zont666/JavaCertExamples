package threads2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pools {

  public static void main( String[] args ) {
    ScheduledExecutorService service = Executors.newScheduledThreadPool( 10 );
    service.scheduleAtFixedRate( () -> System.out.println( Thread.currentThread().getName() +  " - scheduled" ), 3, 1, TimeUnit.SECONDS );
    
    System.out.println( Runtime.getRuntime().availableProcessors() );

  }

}
