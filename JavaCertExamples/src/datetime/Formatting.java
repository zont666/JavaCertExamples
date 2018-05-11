package datetime;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Formatting {

  public static void main( String[] args ) {
    
    ZonedDateTime nowAndHere = ZonedDateTime.now();
    DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern( "MMM d yyyy  hh:mm a" );
    String out = nowAndHere.format( dtFormat );
    System.out.printf( "%s (%s)%n", out, nowAndHere.getZone()  );

  }

}
