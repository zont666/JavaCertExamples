package datetime.india;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class TimeZones {

  public static void main( String[] args ) {
    System.out.println("My zone id is: " + ZoneId.systemDefault());
    System.out.println( ZoneId.getAvailableZoneIds().size() );
    
    ZoneId.getAvailableZoneIds()
    .forEach( System.out::println );
    
    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();
    
    ZoneId myZone = ZoneId.systemDefault();
    ZonedDateTime zonedDateTime = ZonedDateTime.of( currentDate, currentTime, myZone );
    System.out.println( zonedDateTime );
    
    ZoneId calcutta = ZoneId.of( "Asia/Kolkata" );
    LocalDateTime dateTimeNow = LocalDateTime.now();
    ZonedDateTime calcuttaCurrentDateTime = dateTimeNow.atZone( calcutta );
    ZoneOffset zoneOffset = calcuttaCurrentDateTime.getOffset();
    System.out.println( zoneOffset );
    
    ZoneId singaporeZone = ZoneId.of( "Asia/Singapore" );
    ZonedDateTime dateTimeInSing = ZonedDateTime.of( LocalDateTime.of( 2016, Month.JANUARY, 1, 6, 0 ), singaporeZone  );
    
    ZoneId aucklandZone = ZoneId.of("Pacific/Auckland");
    ZonedDateTime sameDateTimeInAuckland = dateTimeInSing.withZoneSameInstant( aucklandZone );
    
    Duration timeDifference = Duration.between( dateTimeInSing.toLocalTime(), sameDateTimeInAuckland.toLocalTime() );
    System.out.printf( "Time difference between %s and %s is %d hours", singaporeZone, aucklandZone, timeDifference.toHours());
    
    

  }

}
