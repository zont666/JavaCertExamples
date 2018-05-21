package datetime.temporal;

import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class StringConverter {

  public static void main( String[] args ) {
    LocalDate date = LocalDate.of( 1996, Month.OCTOBER, 29 );
    System.out.printf( "%s%n", toString( date, JapaneseChronology.INSTANCE ) );
    System.out.printf( "%s%n", toString( date, MinguoChronology.INSTANCE ) );
    System.out.printf( "%s%n", toString( date, ThaiBuddhistChronology.INSTANCE ) );
    System.out.printf( "%s%n", toString( date, HijrahChronology.INSTANCE ) );

    System.out.printf( "%s%n", fromString( "10/29/0008 H", JapaneseChronology.INSTANCE ) );
    System.out.printf( "%s%n", fromString( "10/29/0085 1", MinguoChronology.INSTANCE ) );
    System.out.printf( "%s%n", fromString( "10/29/2539 B.E.", ThaiBuddhistChronology.INSTANCE ) );
    System.out.printf( "%s%n", fromString( "6/16/1417 1", HijrahChronology.INSTANCE ) );

  }

  public static String toString( LocalDate localDate, Chronology chrono ) {
    if ( localDate != null ) {
      Locale locale = Locale.getDefault( Locale.Category.FORMAT );
      ChronoLocalDate cDate;
      if ( chrono == null ) {
        chrono = IsoChronology.INSTANCE;
      }
      try {
        cDate = chrono.date( localDate );
      }
      catch ( DateTimeException ex ) {
        System.err.println( ex );
        chrono = IsoChronology.INSTANCE;
        cDate = localDate;
      }
      String pattern = "M/d/yyyy GGGGG";
      DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern( pattern, locale );
      return dateFormatter.format( cDate );
    }
    else {
      return "";
    }
  }

  public static LocalDate fromString( String text, Chronology chrono ) {
    if ( text != null && !text.isEmpty() ) {
      Locale locale = Locale.getDefault( Locale.Category.FORMAT );
      if ( chrono == null ) {
        chrono = IsoChronology.INSTANCE;
      }
      String pattern = "M/d/yyyy GGGGG";

      DateTimeFormatter df = new DateTimeFormatterBuilder().parseLenient() //
          .appendPattern( pattern ) //
          .toFormatter() //
          .withChronology( chrono ) //
          .withDecimalStyle( DecimalStyle.of( locale ) );

      TemporalAccessor temporal = df.parse( text );
      ChronoLocalDate cDate = chrono.date( temporal );
      return LocalDate.from( cDate );
    }

    return null;
  }

}
