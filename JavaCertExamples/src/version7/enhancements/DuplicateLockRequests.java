package version7.enhancements;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DuplicateLockRequests {

  public static void main( String[] args ) {
    Lock lock = new ReentrantLock();

    try {
      lock.lock();
      lock.lock();
      System.out.println( "test" );
    }
    finally {
      lock.unlock();
      //lock.unlock();
    }

    new Thread( () -> {
      if(lock.tryLock()) {
        try {
          System.out.println( "Acquired Lock" );
        }finally {
          lock.unlock();
        }
      }else {
        System.out.println( "Lock unavailable" );
      }
    } ).start();

  }

}
