package datetime.india;

import java.time.*;

public class DatesAndTimes {

  public static void main( String[] args ) {
    long visaValidityDays = 180L;

    LocalDate currentDate = LocalDate.now();
    System.out.println( currentDate.plusDays( visaValidityDays ) );

    System.out.println( LocalDateTime.now( ZoneId.of( "Australia/Sydney" ) ) );

    LocalTime currentTime = LocalTime.now();
    System.out.println( currentTime.plusHours( 6 ).plusMinutes( 30 ) );

    LocalDateTime xmas = LocalDateTime.of( 2018, Month.DECEMBER, 25, 0, 0 );
    LocalDateTime newYears = LocalDateTime.of( 2019, Month.JANUARY, 1, 0, 0 );

    System.out.println( "newYears is AFTER xmas: " + newYears.isAfter( xmas ) );
    System.out.println( "xmas is BEFORE new years: " + xmas.isBefore( newYears ) );

    System.out.println( "days between the two dates: " + Period.between( xmas.toLocalDate(), newYears.toLocalDate() ).getDays() );

    Instant currentTimeStamp = Instant.now();
    System.out.println( "currentTimeStamp: " + currentTimeStamp );

    System.out.println( "Number of seconds elapsed: " + currentTimeStamp.getEpochSecond() );

    System.out.println( "Number of milliseconds elapsed: " + currentTimeStamp.toEpochMilli() );

    System.out.println( "Instant.now(): " + Instant.now() );
    System.out.println( "LocalDateTime.now(): " + LocalDateTime.now() );

    LocalDateTime comingMidnight = LocalDateTime.of( LocalDate.now().plusDays( 1 ), LocalTime.MIDNIGHT );
    System.out.println( comingMidnight );
    Duration time = Duration.between( LocalDateTime.now(), comingMidnight );
    System.out.println( time );
  }

}
