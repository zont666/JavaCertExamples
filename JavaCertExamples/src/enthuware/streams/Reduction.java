package enthuware.streams;

import java.util.stream.Stream;

public class Reduction {

  public static void main( String[] args ) {
    Stream<String> names = Stream.of( "Sarah Adams", "Suzy Pinnell", "Paul Basgall" );
    names.map( e -> e.split( " " )[0] ).forEach( System.out::println );

  }

}
