package streams.india;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingAndPartitioning {

  public static void main( String[] args ) {
    
    //Good GroupingBy example
    String[] words = "you never know what you have until you clean your room".split( " " );
    Stream<String> distinctWords = Arrays.stream( words ).distinct();
    Map<Integer, List<String>> wordGroups = distinctWords.collect( Collectors.groupingBy( String::length ) );
    wordGroups.forEach( ( count, wrds ) -> {
      System.out.printf( "words of length %d %n", count );
      wrds.forEach( System.out::println );
    } );
    
    
    Stream<String> distinctWords2 = Arrays.stream( words ).distinct();
    Map<Boolean, List<String>> wordBlocks = distinctWords2.collect( Collectors.partitioningBy( str -> str.length() > 4 ) );
    System.out.println( "words of length greater than 4: " + wordBlocks.get( true ) );
    System.out.println( "words of length less than 4: " + wordBlocks.get( false ) );
  }

}
