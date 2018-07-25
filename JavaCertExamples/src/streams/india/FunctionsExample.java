package streams.india;

import java.util.Arrays;
import java.util.function.Function;

public class FunctionsExample {

  public static void main( String[] args ) {
//    Arrays.stream( "4, -9, 16, -99, 98, -100, 0".split( ", " ) )
//    .map( Integer::parseInt )
//    .map( i -> (i < 0) ? -i : i )
//    .forEach( System.out::println );
    
//    Function<String, Integer> parseInt = Integer::parseInt;
//    Function<Integer, Integer> absInt = Math::abs;
//    Function<String, Integer> parseAndAbsInt = parseInt.andThen( absInt );
//    
//    
//    Arrays.stream( "4, -9, 16, -99, 98, -100, 0".split( ", " ) )
//    .map(parseAndAbsInt)
//    .forEach( System.out::println );
    
    
    Arrays.stream( "4, -9, 16, -99, 98, -100, 0".split( ", " ) )
    .map(Function.identity())
    .forEach( System.out::println );

  }

}
