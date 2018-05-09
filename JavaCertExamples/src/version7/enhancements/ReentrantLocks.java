package version7.enhancements;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {

  public static void main( String[] args ) {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool( 20 );
      SheepManager sheepManager = new SheepManager();
      for ( int i = 0; i < 20; i++ ) {
        service.submit( () -> sheepManager.incrementAndReport() );
      }
    }
    finally {

    }

  }

}

class SheepManager {
  private int count;
  private Lock lock = new ReentrantLock();

  void incrementAndReport() {
    try {
      lock.lock();
      System.out.print( " " + (++count) );
    }
    finally {
      lock.unlock();
    }
  }
}
