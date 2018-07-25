package streams.india;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamExample {

  public static void main( String[] args ) {
    IntPredicate evenNumbers = i -> (i % 2) == 0;
    
    IntStream.range( 1,  100 )
    .filter( evenNumbers )
    .forEach( System.out::println );
    
    IntFunction absInt = Math::abs;

  }

}
