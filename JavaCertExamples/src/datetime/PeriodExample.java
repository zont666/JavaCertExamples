package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class PeriodExample {

  public static void main( String[] args ) {
    LocalDate todaysDate = LocalDate.now();
    LocalDate birthDate = LocalDate.of( 1960, Month.JULY, 1 );

    Period p = Period.between( birthDate, todaysDate );

    long p2 = ChronoUnit.DAYS.between( birthDate, todaysDate );

    //System.out.printf( "You are %d years, %d months and %d days old%n", p.getYears(), p.getMonths(), p.getDays()  );

    //System.out.printf( "You are %d days old%n", p2  );

    //LocalDate nextBirthday = LocalDate.of( Year.now().getValue(), birthDate.getMonth(), birthDate.getDayOfMonth() );
    LocalDate nextBirthday = birthDate.withYear( Year.now().getValue() );
    //System.out.println( thisYearsBirthday );

    System.out.println( todaysDate.getDayOfYear() );
    System.out.println( nextBirthday.getDayOfYear() );
    //System.out.println( birthDate.getDayOfYear() );

    //if ( todaysDate.getDayOfYear() > nextBirthday.getDayOfYear() ) {
    if ( nextBirthday.isBefore( todaysDate ) || nextBirthday.isEqual( todaysDate ) ) {
      nextBirthday = nextBirthday.plusYears( 1 );
    }

    //}

    Period period = Period.between( todaysDate, nextBirthday );
    long days = ChronoUnit.DAYS.between( todaysDate, nextBirthday );
    System.out.println( period );
    System.out.printf( "%d months and %d days until your next birthday (%d days in total)%n", period.getMonths(), period.getDays(), days );

  }

}
