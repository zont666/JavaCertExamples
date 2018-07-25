package enthuware.streams;

import java.util.Arrays;
import java.util.List;

public class StringBuilding {

  public static void main( String[] args ) {
    List<StringBuilder> messages = Arrays.asList( new StringBuilder(), new StringBuilder() );
    messages.stream().forEach( s -> s.append( "helloworld" ) );
    messages.forEach( s -> {
      s.insert( 5, "," );
      System.out.println( s );
    } );

  }

}
