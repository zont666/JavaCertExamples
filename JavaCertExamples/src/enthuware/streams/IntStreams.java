package enthuware.streams;

import java.util.stream.IntStream;

public class IntStreams {

  public static void main( String[] args ) {
    IntStream is = IntStream.range(1, 4);
    int sum = is.reduce( 0, (a,b) -> a + b );
    System.out.println( sum );

  }

}
