package datetime;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class DayOfWeekExample {

  public static void main( String[] args ) {
    LocalDate localDate = LocalDate.of( 2000, Month.NOVEMBER, 20 );
    System.out.println( localDate.getDayOfWeek().toString() );
    LocalDate nextWednesday = localDate.with( TemporalAdjusters.next( DayOfWeek.WEDNESDAY ) );

    System.out.println( nextWednesday );

    DayOfWeek dotw = LocalDate.of( 2012, Month.JULY, 10 ).getDayOfWeek();
    System.out.println( dotw );

  }

}
