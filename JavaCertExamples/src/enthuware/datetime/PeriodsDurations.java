package enthuware.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class PeriodsDurations {

  public static void main( String[] args ) {
    Period p = Period.between( LocalDate.now(), LocalDate.of( 2015, Month.SEPTEMBER, 1 ) );
    System.out.println( p );
    
    Duration d = Duration.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1));
    System.out.println(d);
  }

}
