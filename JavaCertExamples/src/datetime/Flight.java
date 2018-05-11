package datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {

  public static void main( String[] args ) {
    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern( "MMMM d yyyy hh:mm a" );
    
    LocalDateTime departureLocalDateTime = LocalDateTime.of( 2013, Month.JULY, 20, 19, 30 );
    ZoneId departureZone = ZoneId.of( "America/Los_Angeles" );
    ZonedDateTime departureZonedDateTime = ZonedDateTime.of( departureLocalDateTime, departureZone );
    
    String out1 = departureZonedDateTime.format( dateTimeFormat );
    System.out.printf( "LEAVING:   %s (%s)%n", out1, departureZone  );
    
    ZoneId arrivalZone = ZoneId.of( "Asia/Tokyo" );
    ZonedDateTime arrivalZonedDateTime = departureZonedDateTime.withZoneSameInstant( arrivalZone ).plusMinutes( 650 );
    
    String out2 = arrivalZonedDateTime.format( dateTimeFormat );
    System.out.printf( "ARRIVING:  %s (%s)%n", out2, arrivalZone  );
    
    if(arrivalZone.getRules().isDaylightSavings( arrivalZonedDateTime.toInstant() )) {
      System.out.printf( "(%s daylight saving time will be in effect.)%n", arrivalZone  );
    }else {
      System.out.printf( "(%s standard time will be in effect.)%n", arrivalZone  );
    }

  }

}
