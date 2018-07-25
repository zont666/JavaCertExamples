package enthuware.streams;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class OptionalDoubleExample {

  public static void main( String[] args ) {
    IntStream ints = IntStream.range( 0, 5 );
    OptionalDouble x = ints.average();
    System.out.println( x );

    System.out.println( IntStream.empty().average() );

  }

}
