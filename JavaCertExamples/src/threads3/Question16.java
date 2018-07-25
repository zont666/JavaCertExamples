package threads3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

public class Question16 {

  public static void main( String[] args ) {
    ExecutorService service = Executors.newScheduledThreadPool( 10 );
    DoubleStream.of( 3.14159, 2.71828 ) // b1
        .forEach( c -> service.submit( // b2
            () -> System.out.println( 10 * c ) ) );
    service.execute( () -> System.out.println( "Printed" ) ); // b4
    
    service.shutdown();

  }

}
