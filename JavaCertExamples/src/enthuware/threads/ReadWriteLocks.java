package enthuware.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {

  public static void main( String[] args ) {
    final Student student = new Student();
    ExecutorService executor = Executors.newFixedThreadPool( 2 );

    executor.submit( () -> {
      int x = 0;
      for ( ;; x++ ) {
        int mark = ThreadLocalRandom.current().nextInt();
        System.out.println( "Sub - " + x + "  : Mark - " + mark );
        student.setMarksInSubject( "Sub" + x, mark );
      }

    } );

    executor.submit( () -> {
      for ( ;; ) {
        double average = student.getAverageMarks();
        System.out.println( "average: " + average );
      }

    } );

    executor.shutdown();

  }

  static class Student {
    private Map<String, Integer> marksObtained = new HashMap<String, Integer>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void setMarksInSubject( String subject, Integer marks ) {
      System.out.println( "trying to acquire write lock" );
      lock.writeLock().lock();
      System.out.println( "acquired write lock" );

      try {
        marksObtained.put( subject, marks );
      }
      finally {
        System.out.println( "releasing write lock" );
        lock.writeLock().unlock();
        System.out.println( "released write lock" );
      }
    }

    public double getAverageMarks() {
      System.out.println( "trying to acquire read lock" );
      lock.readLock().lock();
      System.out.println( "acquired read lock" );
      double average;
      try {
        average = marksObtained.values().stream().mapToInt( x -> x ).average().orElse( 0.0 );
      }
      finally {
        System.out.println( "releasing read lock" );
        lock.readLock().unlock();
        System.out.println( "released read lock" );
      }

      return average;
    }
  }

}
