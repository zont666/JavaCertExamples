package version7.enhancements.interfaces.timeclients;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleTimeClient implements TimeClient {

  public static void main( String[] args ) {
    TimeClient timeClient = new SimpleTimeClient();
    System.out.println( "LocalDateTime: " + timeClient.getLocalDateTime() );
    System.out.println( "DateTime in California: " + timeClient.getZonedDateTime( "America/Los_Angeles" ) );
  }

  private LocalDateTime localDateTime;

  public SimpleTimeClient() {
    localDateTime = LocalDateTime.now();
  }

  @Override
  public void setTime( int hour, int minute, int second ) {
    LocalTime localTime = LocalTime.of( hour, minute, second );
    this.localDateTime = LocalDateTime.of( localDateTime.toLocalDate(), localTime );

  }

  @Override
  public void setDate( int day, int month, int year ) {
    LocalDate localDate = LocalDate.of( year, month, day );
    this.localDateTime = LocalDateTime.of( localDate, localDateTime.toLocalTime() );

  }

  @Override
  public void setDateAndTime( int day, int month, int year, int hour, int minute, int second ) {
    LocalDate localDate = LocalDate.of( year, month, day );
    LocalTime localTime = LocalTime.of( hour, minute, second );
    this.localDateTime = LocalDateTime.of( localDate, localTime );

  }

  @Override
  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

}
