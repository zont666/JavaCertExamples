package enthuware.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Adjusting {

  public static void main( String[] args ) {
    System.out.println( LocalDate.now().with( TemporalAdjusters.next( LocalDate.now().getDayOfWeek()  ) ) );
    System.out.println( LocalDate.now().with( TemporalAdjusters.nextOrSame( LocalDate.now().getDayOfWeek() ) ) );
    
    System.out.println( TemporalAdjusters.next( DayOfWeek.THURSDAY ).adjustInto( LocalDate.now() ) );

  }

}
