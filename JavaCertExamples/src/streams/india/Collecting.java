package streams.india;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collecting {

  public static void main( String[] args ) {
    String frenchCounting = "un:deux:trois:quatre";
    List<String> list = Pattern.compile( ":" ).splitAsStream( frenchCounting ).collect( Collectors.toList() );

    System.out.println( list );

    String[] roseQuote = "a rose is a rose is a rose".split( " " );
    Set set = Arrays.stream( roseQuote ).collect( Collectors.toSet() );
    System.out.println( set );

    Map<String, Integer> nameLength = Stream.of( "Arnold", "Alois", "Schwarzenegger" ).collect( Collectors.toMap( Function.identity(), name -> name.length() ) );
    System.out.println( nameLength );

    String[] roseQuote2 = "a rose is a rose is a rose".split( " " );
    Set<String> set2 = Arrays.stream( roseQuote ).collect( Collectors.toCollection( TreeSet::new ) );
    System.out.println( set2 );

  }

}
