package threads2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schedulor {

  public static void main( String[] args ) throws InterruptedException, ExecutionException {

    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    Runnable task1 = () -> System.out.println( "Hello zoo" );
    Callable<String> task2 = () -> "Monkey";

    Future<?> results1 = service.schedule( task1, 1, TimeUnit.SECONDS );
    Future<?> results2 = service.schedule( task2, 2, TimeUnit.SECONDS );
    
    service.scheduleAtFixedRate( () -> System.out.println( "Scheduled task running..." ), 0, 1, TimeUnit.SECONDS );
    
    
    
    service.shutdown();
    
    System.out.println( results1.get() );
    System.out.println( results2.get() );


  }

}
