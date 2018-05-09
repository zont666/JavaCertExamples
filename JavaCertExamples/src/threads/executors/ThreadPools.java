package threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {

  public static void main( String[] args ) {

     ExecutorService exService = Executors.newFixedThreadPool( 5 );
     //ExecutorService exService = Executors.newCachedThreadPool();
    //ExecutorService exService = Executors.newSingleThreadExecutor();
    
    for( ;; ) {
      try {
        Thread.sleep( 2000 );
        exService.submit( () -> {
          Thread currentThread = Thread.currentThread();
          System.out.format( "%s is currently running with a state of %s and priority of %s%n", currentThread.getName(), currentThread.getState().name(), currentThread.getPriority()  );
        });
      }
      catch ( InterruptedException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    
    

  }
  
 

}
