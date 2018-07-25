package datetime.india;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TemporalUnitExample {

  public static void main( String[] args ) {
    System.out.println( "ChronoUnit \t DateBased \t TimeBased \t Duration" );
    System.out.println( "---------------------------------------------------------" );
    for ( ChronoUnit unit : ChronoUnit.values() ) {
      System.out.printf("%10s \t %b \t\t %b \t\t %s %n",
          unit, unit.isDateBased(), unit.isTimeBased(), unit.getDuration());
    }

    
    System.out.println( Duration.of( 3, ChronoUnit.DAYS ) );
  }

}
