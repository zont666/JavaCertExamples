package version7.enhancements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLocks {

  private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private List<String> names = new ArrayList<>();

  public ReentrantReadWriteLocks() {
    names.add( "John Smith" );
    names.add( "Sarah Smith" );
    names.add( "James Johnson" );
  }

  private String readNames( int i ) {
    Lock readLock = readWriteLock.readLock();
    try {
      readLock.lock();
      System.out.println( "Read Lock Acquired!!!!" );
      return names.get( i % names.size() );
    }
    finally {
      readLock.unlock();
      System.out.println( "Read Lock Released!!!!" );
    }

  }

  private void addName( String name ) {
    Lock writeLock = readWriteLock.writeLock();
    try {
      writeLock.lock();
      System.out.println( "Write Lock Acquired!!!!" );
      Thread.sleep( 1000 );
      names.add( name );
    }
    catch ( InterruptedException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally {
      writeLock.unlock();
      System.out.println( "Write Lock Released!!!!" );
    }
  }

  public static void main( String[] args ) {
    ReentrantReadWriteLocks lockManager = new ReentrantReadWriteLocks();

    ExecutorService service = null;

    try {
      service = Executors.newFixedThreadPool( 20 );
      for ( int i = 0; i < 100; i++ ) {
        final int employeeNumber = i;
        service.submit( () -> lockManager.readNames( employeeNumber ) );
      }
      service.submit( () -> lockManager.addName( "Johnny Vegas" ) );
      service.submit( () -> lockManager.addName( "Joey Davis" ) );
    }
    finally {
      if ( service != null ) {
        System.out.println( "SHUTDOWN IN PROGRESS" );
        service.shutdown();
      }
    }
  }

}
