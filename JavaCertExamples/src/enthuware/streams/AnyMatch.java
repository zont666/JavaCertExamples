package enthuware.streams;

import java.util.stream.Stream;

public class AnyMatch {

  public static void main( String[] args ) {
    String sentence = "Life is a box of chocolates, Forrest. You never know what you're gonna get."; //1
    boolean output = Stream.of( sentence.split( "[,.]" ) ).anyMatch( w -> w.startsWith( "g" ) );
    System.out.println( output );
  }

}
