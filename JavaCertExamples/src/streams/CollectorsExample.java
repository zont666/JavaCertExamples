package streams;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

  public static void main( String[] args ) {

    Stream<String> ohMy = Stream.of( "lions", "tigers", "bears" );

    //joining()
    //String result = ohMy.collect( Collectors.joining( ", " ) );
    //ystem.out.println( result );

    //averaging()
    //Double result = ohMy.collect( Collectors.averagingInt( String::length ) );
    //System.out.println( result );

    //toCollection()
    //TreeSet<String> result = ohMy.filter( s -> s.startsWith( "t" ) ) //
    //        .collect( Collectors.toCollection( TreeSet::new ) );
    //System.out.println( result );

    //toSet()
    //Set<String> result = ohMy.filter( s -> s.startsWith( "t" ) ) //
    //        .collect( Collectors.toSet() );
    //System.out.println( result );

    //counting()
    // long result = ohMy.collect( Collectors.counting() );
    //System.out.println( result );

    //maxBy()
    //ohMy.collect( Collectors.maxBy( String::compareTo ) );
    //ohMy.collect( Collectors.maxBy( (s1, s2) -> s1.compareTo(s2) ) );
    //    Optional<String> result = ohMy.collect( Collectors.maxBy( Comparator.comparing( String::length ) ) );
    //    result.ifPresent( System.out::println );

    //Collecting into a map
    //Map<String, Integer> map = ohMy.collect( Collectors.toMap( s -> s, String::length ) );
    //System.out.println( map );

    //Collecting into a map and providing a merge function
    //    Map<Integer, String> map = ohMy.collect( Collectors.toMap( String::length, k -> k, ( s1, s2 ) -> s1 + ", " + s2 ) );
    //    System.out.println( map );
    //    System.out.println( map.getClass() );

    //Collecting into a concrete map type and providing a merge function
    //    TreeMap<Integer, String> map = ohMy.collect( Collectors.toMap( String::length, k -> k, ( s1, s2 ) -> s1 + ", " + s2, TreeMap::new ) );
    //    System.out.println( map );
    //    System.out.println( map.getClass() );

    //groupingBy()
    //    Map<Integer, List<String>> map = ohMy.collect( Collectors.groupingBy( String::length ) );
    //    System.out.println( map );
    //    System.out.println( map.getClass() );

    //groupingBy() but providing a Set downstream collector
    //    Map<Integer, Set<String>> map = ohMy.collect( Collectors.groupingBy( String::length, Collectors.toSet() ) );
    //    System.out.println( map );

    //groupingBy() but providing a Set downstream collector and concrete Map type
    //    TreeMap<Integer, Set<String>> map = ohMy.collect( Collectors.groupingBy( String::length, TreeMap::new, Collectors.toSet() ) );
    //    System.out.println( map );
    //    System.out.println( map.getClass() );

    //groupingBy() but providing a List downstream collector and concrete Map type but 
    //    TreeMap<Integer, List<String>> map = ohMy.collect( Collectors.groupingBy( String::length, TreeMap::new, Collectors.toList() ) );
    //    System.out.println( map );

    //partitioningBy()
    //    Map<Boolean, List<String>> map = ohMy.collect( Collectors.partitioningBy( s -> s.length() > 5 ) );
    //    System.out.println( map );

    //partitioningBy() specifying a downstream collection type
    //    Map<Boolean, Set<String>> map = ohMy.collect( Collectors.partitioningBy( s -> s.length() > 5, Collectors.toSet() ) );
    //    System.out.println( map );

    //groupingBy() alternative collector
    //    Map<Integer, Long> map = ohMy.collect( Collectors.groupingBy( String::length, Collectors.counting() ) );
    //    System.out.println( map );

    Map<Integer, Optional<Character>> map = ohMy.collect( //
        Collectors.groupingBy( //
            String::length, //
            Collectors.mapping( s -> s.charAt( 0 ), //
                Collectors.minBy( Comparator.naturalOrder() ) ) ) );
    System.out.println( map );

  }

}
