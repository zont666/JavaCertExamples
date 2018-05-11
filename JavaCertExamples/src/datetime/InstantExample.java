package datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class InstantExample {

  public static void main( String[] args ) {
    Instant now = Instant.now();
    System.out.println( now );

    Instant oneHourLater = Instant.now().plus( 1, ChronoUnit.HOURS );

    System.out.println( oneHourLater );
    
    long secondsFromEpoch = Instant.ofEpochSecond( 0L ).until( Instant.now(), ChronoUnit.SECONDS );
    
    System.out.println( secondsFromEpoch );
    
    LocalDateTime ldt = LocalDateTime.ofInstant( now, ZoneId.systemDefault() );
    System.out.println( oneHourLater );
    
    System.out.printf(  "%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(), ldt.getYear(), ldt.getHour(), ldt.getMinute() );
    

  }

}
