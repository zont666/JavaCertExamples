package version7.enhancements.interfaces.timeclients;

import java.time.ZonedDateTime;

public interface AbstractZoneTimeClient extends TimeClient {
  ZonedDateTime getZonedDateTime( String zoneString );
}
