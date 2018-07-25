package streams;

import java.util.Optional;
import java.util.stream.Stream;

public class EmptyStream {

  public static void main( String[] args ) {
    //magic( Stream.empty() );
    //magic( Stream.iterate( 1,  x -> x++ ) );
    magic( Stream.of( 5, 10 ) );
  }

  private static void magic( Stream<Integer> s ) {
    Optional o = s.filter( x -> x < 5 ).limit( 3 ).peek( System.out::println).max( ( x, y ) -> x - y );
    System.out.println( o.get() );
  }

}
