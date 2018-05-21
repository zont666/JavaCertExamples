package datetime;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class OracleTutorialQuestions {

  public static void main( String[] args ) {
    //  Q1
    LocalDateTime birthday = LocalDateTime.of( 1985, Month.APRIL, 4, 3, 30 );
    System.out.printf( "%s fell on a %s%n", birthday.toLocalDate(), birthday.getDayOfWeek() );

    //  Q2

    LocalDateTime prevThursday = birthday.with( TemporalAdjusters.previous( DayOfWeek.THURSDAY ) );
    System.out.printf( "previous Thursday falls on %s%n", prevThursday.toLocalDate() );

    //  Q4

    Instant now = Instant.now();

    ZonedDateTime zdt = ZonedDateTime.ofInstant( now, ZoneId.systemDefault() );

    System.out.println( zdt );
    System.out.println( zdt.toInstant() );

    //  Ex 1
    System.out.println( "\n\n\n" );
    Year currentYear = Year.now();

    Month[] monthsInYear = Month.values();
    for ( Month month : Month.values()) {
      YearMonth yearMonth = YearMonth.of( currentYear.getValue(), month );
      System.out.printf( "%s %s has %s days%n", month, yearMonth.getYear(), yearMonth.lengthOfMonth() );
    }


    //  Ex 2
    System.out.println( "\n\n\n" );
    YearMonth monthYear = YearMonth.of( Year.now().getValue(), Month.FEBRUARY );

    LocalDate date2 = monthYear.atDay( 1 );
    date2 = date2.with( TemporalAdjusters.firstDayOfMonth() );

    for ( int i=0; i < 20; i++ ) {
      System.out.println( date2 );
      System.out.println(  monthYear.getMonth() );
      LocalDate nextMonday = date2.with( TemporalAdjusters.nextOrSame( DayOfWeek.MONDAY ) );
      date2 = nextMonday;
      System.out.println( date2 );
      System.out.printf( "%s %s occurs on %s%n", DayOfWeek.MONDAY, i, nextMonday );
    }
    
    LocalDate ldate = LocalDate.of( 2018, Month.APRIL, 13 );
    boolean isFridayThe13th = ldate.getDayOfMonth() == 13 && ldate.getDayOfWeek() == DayOfWeek.FRIDAY;
    System.out.println( isFridayThe13th );

  }

}
