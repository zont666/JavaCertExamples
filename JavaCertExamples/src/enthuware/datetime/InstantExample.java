package enthuware.datetime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantExample {

  public static void main( String[] args ) {
    Instant now = Instant.now();
    Instant now2 = now.truncatedTo( ChronoUnit.DAYS );
    System.out.println( now2 );

  }

}
