package streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class IntStreamsExample {

  public static void main( String[] args ) {
    long startTime = System.currentTimeMillis();

    AtomicInteger ints = new AtomicInteger( 0 );
    Stream.generate( ints::incrementAndGet ).limit( 1000000 ).forEach( System.out::println );
    //IntStream.generate( ints::incrementAndGet ).limit( 1000000 ).forEach( System.out::println );

    long endTime = System.currentTimeMillis();

    System.out.format( "Finished in %d milliseconds", (endTime - startTime) );

  }

}
