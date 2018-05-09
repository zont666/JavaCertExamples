package version7.enhancements.interfaces.timeclients;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient {

  void setTime( int hour, int minute, int second );

  void setDate( int day, int month, int year );

  void setDateAndTime( int day, int month, int year, int hour, int minute, int second );

  LocalDateTime getLocalDateTime();

  static ZoneId getZoneId( String zoneId ) {
    try {
      return ZoneId.of( zoneId );
    }
    catch ( DateTimeException e ) {
      System.err.println( "Invalid time zone: " + zoneId + "; using default time zone instead." );
      return ZoneId.systemDefault();
    }

  }

  default ZonedDateTime getZonedDateTime( String zoneId ) {
    return ZonedDateTime.of( getLocalDateTime(), getZoneId( zoneId ) );
  }

}
