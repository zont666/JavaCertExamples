package threads2.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {

  private void removeAnimals() {
    System.out.println( "Removing animals" );
  }

  private void cleanPen() {
    System.out.println( "Cleaning the pen" );
  }
 
  private void addAnimals() {
    System.out.println( "Adding animals" );
  }
  
  public void performTask( CyclicBarrier barrier ) {
    try {
      removeAnimals();
      barrier.await();
      cleanPen();
      barrier.await();
      addAnimals();
    }
    catch ( InterruptedException | BrokenBarrierException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String[] args ) {
    ExecutorService service = Executors.newFixedThreadPool( 4 );

    LionPenManager manager = new LionPenManager();
    CyclicBarrier b1 = new CyclicBarrier( 4 );

    for ( int i = 0; i < 4; i++ ) {
      service.submit( () -> manager.performTask( b1 ) );
    }
    
    service.shutdown();

  }

}
