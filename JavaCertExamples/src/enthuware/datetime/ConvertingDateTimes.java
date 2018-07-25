package enthuware.datetime;

import java.time.*;
import java.time.temporal.*;

public class ConvertingDateTimes {

  public static void main( String[] args ) {
    Instant start = Instant.parse( "2015-06-25T16:13:30.00z" );
    start.plus( 10, ChronoUnit.HOURS );
    System.out.println( start );

    Duration timeToCook = Duration.ofHours( 1 );
    Instant readyTime = start.plus( timeToCook );
    System.out.println( readyTime );

    LocalDateTime ltd = LocalDateTime.ofInstant( readyTime, ZoneId.of( "GMT+2" ) );
    System.out.println( ltd );

  }

}
