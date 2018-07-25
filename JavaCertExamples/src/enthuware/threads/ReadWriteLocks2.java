package enthuware.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks2 {

  private final List<String> theList = new ArrayList<String>();
  private final ReadWriteLock rwl = new ReentrantReadWriteLock();
  private final Lock r = rwl.readLock();
  private final Lock w = rwl.writeLock();

  public String read() {
    r.lock();
    try {
      System.out.println( "reading" );
      if ( theList.isEmpty() ) {
        return null;
      }
      else {
        return theList.get( 0 );
      }
    }
    finally {
      r.unlock();
    }
  }

  public void write( String data ) {
    w.lock();
    try {
      System.out.println( "writing " + data );
      theList.add( data );
    }
    finally {
      w.unlock();
    }
  }

  public static void main( String[] args ) {
    ExecutorService executor = Executors.newWorkStealingPool();
    ReadWriteLocks2 rwLocks = new ReadWriteLocks2();

    try {
      for ( int i = 0; i < 5000; i++ ) {
        executor.submit( () -> {
          int randomNumber = ThreadLocalRandom.current().nextInt();
          if ( randomNumber % 2 == 0 ) {
            String data = rwLocks.read();
            System.out.println( Thread.currentThread().getName() + " read " + data );
          }
          else {
            rwLocks.write( "" + randomNumber );
            System.out.println( Thread.currentThread().getName() + " wrote " + randomNumber );
          }
        } );
      }
    }
    finally {
      executor.shutdown();
      System.out.println( rwLocks.theList );
    }

  }

}
