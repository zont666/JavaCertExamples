package streams.india;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TerminalOperations {
  public static void main( String[] args ) {

    //approach #1
    Object[] words = Pattern.compile( " " ).splitAsStream( "1 2 3 4 5" ).toArray();
    System.out.println( //
        Arrays.stream( words ) //
            .mapToInt( str -> Integer.valueOf( (String)str ) ) //
            .sum() //
    );

    //approach #2
    System.out.println( Pattern.compile( " " ).splitAsStream( "1 2 3 4 5" ).mapToInt( s -> Integer.valueOf( (String)s ) ).sum() );

    "superfragilistic".chars() //
        .distinct() //
        .sorted(  ) //
        .forEach( ch -> System.out.printf( "%c", ch ) );

  }
}
