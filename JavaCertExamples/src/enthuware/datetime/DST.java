package enthuware.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DST {

  public static void main( String[] args ) {
    LocalDateTime ldt = LocalDateTime.of( 2015, Month.OCTOBER, 31, 10, 0 );
    System.out.println( ldt );
    
    ZonedDateTime zdt = ZonedDateTime.of( ldt, ZoneId.of( "US/Eastern" ) );
    System.out.println( zdt );
    zdt = zdt.plus( Duration.ofDays( 1 ) );
    System.out.println( zdt );
    
    zdt = ZonedDateTime.of( ldt, ZoneId.of( "US/Eastern" ) );
    zdt = zdt.plus( Period.ofDays( 1 ) );
    System.out.println( zdt );
    
    LocalDateTime lll = LocalDateTime.now();
    
    System.out.println( lll.atZone( ZoneId.of( "US/Eastern" ) ) );
    
    System.out.println( ZonedDateTime.now( ZoneId.of( "US/Eastern" ) ) );

  }

}
