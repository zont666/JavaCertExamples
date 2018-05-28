package version7.enhancements;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterface {

  public static void main( String[] args ) {
    Object object = new Object();
    synchronized ( object ) {
      System.out.println( object );
    }
    
    Lock lock = new ReentrantLock();
    try {
      lock.lock();
      System.out.println( lock );
    }finally {
      lock.unlock();
    }
    
    Runnable r = () -> {
      try {
        if(lock.tryLock(10, TimeUnit.SECONDS)) {
          System.out.println(  object);
        }else {
          System.out.println( "dont have lock" );
        }
      }
      catch ( InterruptedException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    };
    new Thread(r).start();



  }

}
