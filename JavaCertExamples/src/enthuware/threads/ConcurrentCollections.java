package enthuware.threads;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentCollections {

  static ConcurrentMap<String, Object> chm = new ConcurrentHashMap<>();

  public static void main( String[] args ) {
    chm.put( "a", "aaa" );
    chm.put( "b", "bbb" );
    chm.put( "c", "ccc" );

    ExecutorService executor = Executors.newFixedThreadPool( 2 );

    executor.execute( () -> {
      Iterator<Entry<String, Object>> iterator = chm.entrySet().iterator();
      while ( iterator.hasNext() ) {
        Entry<String, Object> entry = iterator.next();
        if ( entry.getKey().equals( "a" ) || entry.getKey().equals( "b" ) ) {
          iterator.remove();
        }
      }
    } );

    executor.execute( () -> {
      Iterator<Entry<String, Object>> iterator = chm.entrySet().iterator();
      while ( iterator.hasNext() ) {
        Entry<String, Object> entry = iterator.next();
        System.out.print( entry.getKey() + ", " );
      }
    } );
    
    executor.shutdown();

  }

}
