package datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DurationExample {

  public static void main( String[] args ) {
    Instant now = Instant.now();
    Instant then = now.minus( 1, ChronoUnit.DAYS );
    System.out.println( Duration.between( now, then ) );
    
    Duration gap = Duration.of( 1000, ChronoUnit.SECONDS );
    Instant later = now.plus( gap );
    System.out.println( later );
    
    System.out.println( ChronoUnit.MILLIS.between( then, LocalDate.now() ) );
  }

}
