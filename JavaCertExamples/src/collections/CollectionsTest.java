package collections;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsTest {

  public static void main( String[] args ) {
    List<Integer> source = new ArrayList<>( Arrays.asList( 1, 2, 3, 4 ) );
    List<Integer> fish = new CopyOnWriteArrayList<>( source );
    List<Integer> mammals = Collections.synchronizedList( source );
    Set<Integer> birds = new ConcurrentSkipListSet<>();
    birds.addAll( source );

    synchronized ( new Integer( 10 ) ) {
      for ( Integer f : fish ) {
        fish.add( 4 );
      }
      for ( Integer m : mammals ) {
        mammals.add( 4 );
      }
      for ( Integer b : birds ) {
        birds.add( 5 );
      }
      System.out.println( fish.size() + " " + mammals.size() + " " + birds.size() );
    }
  }

}
