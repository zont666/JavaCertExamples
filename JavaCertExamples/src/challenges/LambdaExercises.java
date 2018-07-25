package challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class LambdaExercises {

  private static Comparator<String> SORT_BY_LENGTH = ( s1, s2 ) -> s1.length() - s2.length();
  private static Comparator<String> SORT_BY_LENGTH_REVERSED = SORT_BY_LENGTH.reversed();
  private static Comparator<String> SORT_ALPHABETICALLY_BY_1ST_CHAR = ( s1, s2 ) -> Character.compare( s1.charAt( 0 ), s2.charAt( 0 ) );

  public static void main( String[] args ) {
    System.out.printf( "average: %s%n", average( Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ) ) );
    System.out.println( upperCase( Arrays.asList( "atrophy", "bake", "apt", "ace" ) ) );
    System.out.println( search( Arrays.asList( "atrophy", "bake", "apt", "ace" ) ) );
    System.out.println( getString( Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ) ) );
    System.out.println( calculate( 62.000, false, false, true, false ) );

    String[] strs = { "asdfsda", "3654", "dfhhd", "sdfgfsd", "sdfgsdgs" };
    Arrays.sort( strs, Comparator.comparing( String::length ) );
    System.out.println( Arrays.asList( strs ) );
    Arrays.sort( strs, Comparator.comparing( String::length ).reversed() );
    System.out.println( Arrays.asList( strs ) );
    
    new Random().ints().forEach( System.out::println );
  }

  public static int sortByLength( String s1, String s2 ) {
    return s1.length() - s2.length();
  }


  public static Double average( List<Integer> list ) {
    return list.stream().mapToInt( i -> i ).average().getAsDouble();
  }

  public static List<String> upperCase( List<String> list ) {
    return list.stream().map( String::toUpperCase ).collect( Collectors.toList() );
  }

  public static List<String> search( List<String> list ) {
    return list.stream().filter( str -> str.startsWith( "a" ) && str.length() == 3 ).collect( Collectors.toList() );
  }

  public static String getString( List<Integer> list ) {
    return list.stream().map( i -> (i % 2 == 0) ? "e" + i : "o" + i ).collect( Collectors.joining( ", " ) );
  }

  public static double calculate( double basic, boolean ... bs ) {
    return Optional.of( basic ).map( b -> {
      if ( bs[0] )
        b *= 1.2;
      if ( bs[1] )
        b *= 1.1;
      if ( bs[2] )
        b *= 0.7;
      if ( bs[3] )
        b *= 0.9;
      return b;
    } ).get();
  }

}
