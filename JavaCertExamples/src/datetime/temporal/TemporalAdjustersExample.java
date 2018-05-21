package datetime.temporal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersExample {

  public static void main( String[] args ) {
    LocalDate date = LocalDate.now();
    DayOfWeek dayOfWeek = date.getDayOfWeek();

    System.out.printf( "%s is on a %s%n", date, dayOfWeek );

    System.out.printf( "1st monday of month %s%n", date.with( TemporalAdjusters.firstInMonth( DayOfWeek.MONDAY ) ) );
    
    System.out.printf( "last day of month %s%n",   date.with( TemporalAdjusters.lastDayOfMonth() ) );
    
    System.out.printf( "first day of next month %s%n",   date.with( TemporalAdjusters.firstDayOfNextMonth() ) );
    
    System.out.printf( "first day of next year %s%n",   date.with( TemporalAdjusters.firstDayOfNextYear() ) );
    
    System.out.printf( "first day of year %s%n",   date.with( TemporalAdjusters.firstDayOfYear() ) );

  }

}
