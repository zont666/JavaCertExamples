package threads2.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
  public static void main( String[] args ) {

  }

}

class Rainbow {
  private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private static int pos;
  static Map<Integer, String> colours = new HashMap<>();

  public void addColour( String newColour ) {
    readWriteLock.writeLock().lock();
    try {
      colours.put( new Integer( ++pos ), newColour );
    }
    finally {
      readWriteLock.writeLock().unlock();
    }
  }

  public void display() {
    readWriteLock.readLock().lock();
    try {
      for ( String colour : colours.values() ) {
        System.out.println( colour );
      }
    }
    finally {
      readWriteLock.readLock().unlock();
    }
  }
}
