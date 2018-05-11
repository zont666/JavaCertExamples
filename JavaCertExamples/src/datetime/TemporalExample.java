package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;

public class TemporalExample {

  public static void main( String[] args ) {
    System.out.println( LocalDate.now().isSupported( ChronoField.CLOCK_HOUR_OF_DAY ) );
    System.out.println( LocalDateTime.now().isSupported( ChronoField.CLOCK_HOUR_OF_DAY ) );
    
    System.out.println( LocalTime.now().isSupported( ChronoField.DAY_OF_MONTH ) );
    
    System.out.println( LocalTime.now().get( ChronoField.HOUR_OF_DAY ) );
    
    System.out.println( LocalDate.now().get( IsoFields.QUARTER_OF_YEAR ) );
    
    System.out.println( Instant.now().isSupported(ChronoUnit.MONTHS) );
  }

}
