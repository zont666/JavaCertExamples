package datetime;

import java.time.Month;
import java.time.MonthDay;

public class MonthDayExample {

  public static void main( String[] args ) {
    MonthDay date = MonthDay.now();
    System.out.println( date );
    
    MonthDay anotherDate = MonthDay.of( Month.FEBRUARY, 29 );
    System.out.println( anotherDate.isValidYear( 2010 ) );

  }

}
