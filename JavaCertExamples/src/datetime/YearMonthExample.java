package datetime;

import java.time.YearMonth;

public class YearMonthExample {

  public static void main( String[] args ) {
    YearMonth date = YearMonth.now();
    System.out.println( date );
    
    System.out.printf( "%s: %d%n", date, date.lengthOfMonth() );

  }

}
