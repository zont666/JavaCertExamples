package streams.india;

import java.util.Arrays;
import java.util.List;

public class FlatMap {

  public static void main( String[] args ) {
    String []string= "you never know what you have until you clean your room".split(" ");
    Arrays.stream(string)
     .flatMap( word -> Arrays.stream( word.split( "" ) ) )
    .distinct()
    .forEach( System.out::println );
    
    System.out.println( "\n\n\n\n\n\n" );
    
    List<Integer> intList = Arrays.asList( 1, 2, 3, 4, 5 );
    intList.stream()
           .map( i -> i * i )
           .forEach( System.out::println );
    
    System.out.println( "\n\n\n\n\n\n" );
    List<List<Integer>> listOfListsOfInts = Arrays.asList( Arrays.asList( 1, 3, 5 ), Arrays.asList( 2, 4 ) );
    listOfListsOfInts.stream()
            .flatMap( ints -> ints.stream() )
            .sorted()
            .map( i -> i * i )
            .forEach( System.out::println );
           

  }

}
