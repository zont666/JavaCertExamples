package datetime.india;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class DaylightSavings {

  public static void main( String[] args ) {
    ZoneId kolkataZone = ZoneId.of( "Asia/Kolkata" );
    Duration kolkateDST = kolkataZone.getRules().getDaylightSavings( Instant.now() );
    System.out.printf( "Kolkata zone DST is %d hours %n", kolkateDST.toHours() );

    ZoneId aucklandZone = ZoneId.of( "Pacific/Auckland" );
    Duration aucklandDST = aucklandZone.getRules().getDaylightSavings( Instant.now() );
    System.out.printf( "Auckland zone DST is %d hours", aucklandDST.toHours() );
  }

}
