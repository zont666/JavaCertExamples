package enthuware.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {

  public static void main( String[] args ) {
    List<String> names = Arrays.asList("greg", "dave", "don", "ed", "fred" );
    Map<Integer, Long> data = names.stream().collect( Collectors.groupingBy( String::length, Collectors.counting() ) );
    System.out.println( data.keySet() );
    System.out.println( data.values() );
    System.out.println( data.entrySet() );
    System.out.println( data.entrySet() );

  }

}
