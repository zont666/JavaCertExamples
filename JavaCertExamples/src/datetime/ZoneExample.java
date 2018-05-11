package datetime;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ZoneExample {

  public static void main( String[] args ) {
    Set<String> allZones = ZoneId.getAvailableZoneIds();
    //allZones.forEach( System.out::println );

    LocalDateTime dt = LocalDateTime.now();

    List<String> zoneList = new ArrayList<>( allZones );
    Collections.sort( zoneList );

    Path timeZoneFile = null;
    try {
      timeZoneFile = Files.createFile( Paths.get( ".\\TimeZones.txt" ) );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try (BufferedWriter tzFileWriter = Files.newBufferedWriter( timeZoneFile, Charset.defaultCharset() )) {
      for ( String s : zoneList ) {
        ZoneId zone = ZoneId.of( s );
        ZonedDateTime zdt = dt.atZone( zone );
        ZoneOffset offset = zdt.getOffset();
        int secondsOfHourRemainder = offset.getTotalSeconds() % (60 * 60);
        String zoneInfoToDisplay = String.format( "%35s %10s%n", zone, offset );

        if ( secondsOfHourRemainder != 0 ) {
          System.out.printf( zoneInfoToDisplay );
          tzFileWriter.write( zoneInfoToDisplay );
        }
      }
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
