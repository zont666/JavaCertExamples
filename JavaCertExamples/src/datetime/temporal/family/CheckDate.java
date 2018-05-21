package datetime.temporal.family;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class CheckDate {

  public static void main( String[] args ) {
    Month month = null;
    LocalDate date = null;

    if ( args.length < 2 ) {
      System.out.printf( "Usage: CheckDate <month> <day>%n" );
      throw new IllegalArgumentException();
    }

    try {
      month = Month.valueOf( args[0].toUpperCase() );
    }
    catch ( IllegalArgumentException exc ) {
      System.out.printf( "%s is not a valid month.%n", args[0] );
      throw exc; // Rethrow the exception.
    }

    int day = Integer.parseInt( args[1] );

    try {
      date = LocalDate.of( Year.now().getValue(), month, day );
    }
    catch ( DateTimeException exc ) {
      System.out.printf( "%s %s is not a valid date.%n", month, day );
      throw exc; // Rethrow the exception.
    }

    //    Boolean isFamilyVacation = date.query( new FamilyVacations() );
    //
    //    Boolean isFamilyBirthday = date.query( FamilyBirthdays::isFamilyBirthday );

    Boolean isFamilyVacation = date.query( ImportantFamilyDates.FAMILY_VACATION );

    Boolean isFamilyBirthday = date.query( ImportantFamilyDates.FAMILY_BIRTHDAY );

    if ( isFamilyVacation || isFamilyBirthday ) {
      System.out.printf( "%s is an important date%n", date );
    }
    else {
      System.out.printf( "%s is NOT an important date%n", date );
    }

  }

}
