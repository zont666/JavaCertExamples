package version7.enhancements;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

  public static void main( String[] args ) {
    DateFormat shortDateFormat = DateFormat.getDateInstance( DateFormat.SHORT );
    DateFormat mediumDateFormat = DateFormat.getDateInstance( DateFormat.MEDIUM );
    DateFormat longDateFormat = DateFormat.getDateInstance( DateFormat.LONG );
    DateFormat fullDateFormat = DateFormat.getDateInstance( DateFormat.FULL );
    
    Date date = Calendar.getInstance().getTime();
    System.out.println( date );
    
    System.out.println( "\nDate Formats:"  );
    System.out.println( shortDateFormat.format( date ) );
    System.out.println( mediumDateFormat.format( date ) );
    System.out.println( longDateFormat.format( date ) );
    System.out.println( fullDateFormat.format( date ) );
    
    
    DateFormat shortDateTimeFormat = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.SHORT );
    DateFormat mediumDateTimeFormat = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.MEDIUM );
    DateFormat longDateTimeFormat = DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.LONG );
    DateFormat fullDateTimeFormat = DateFormat.getDateTimeInstance( DateFormat.FULL, DateFormat.FULL);

    System.out.println( "\nDateTime Formats:"  );
    System.out.println( shortDateTimeFormat.format( date ) );
    System.out.println( mediumDateTimeFormat.format( date ) );
    System.out.println( longDateTimeFormat.format( date ) );
    System.out.println( fullDateTimeFormat.format( date ) );
    
    DateFormat shortDateTimeFormatWithLocale = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.SHORT, Locale.GERMANY );
    DateFormat mediumDateTimeFormatWithLocale = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.GERMANY );
    DateFormat longDateTimeFormatWithLocale = DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.LONG, Locale.GERMANY );
    DateFormat fullDateTimeFormatWithLocale = DateFormat.getDateTimeInstance( DateFormat.FULL, DateFormat.FULL, Locale.GERMANY);
    
    System.out.println( "\nDateTime Formats with Locale:"  );
    System.out.println( shortDateTimeFormatWithLocale.format( date ) );
    System.out.println( mediumDateTimeFormatWithLocale.format( date ) );
    System.out.println( longDateTimeFormatWithLocale.format( date ) );
    System.out.println( fullDateTimeFormatWithLocale.format( date ) );
    
    
    DateFormat usaShortFormat = DateFormat.getDateInstance( DateFormat.SHORT, Locale.US );
    String dateAsString = "01/31/1984";
    
    try {
      Date usaDate = usaShortFormat.parse( dateAsString );
      
      DateFormat franceFullFormat = DateFormat.getDateInstance( DateFormat.FULL, Locale.FRANCE );
      System.out.println( "\nParsing dates from strings"  );
      System.out.println( franceFullFormat.format( usaDate ) );
    }
    catch ( ParseException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    SimpleDateFormat f1 = new SimpleDateFormat("MM dd yyyy hh:mm:ss");
    SimpleDateFormat f2 = new SimpleDateFormat("MMMM yyyy");
    SimpleDateFormat f3 = new SimpleDateFormat("hh");
    
    try {
      Date dateToFormat = f1.parse("01 26 2016 01:22:33");
      System.out.println( "\nCustom date formats"  );
      System.out.println( f1.format( dateToFormat ) );
      System.out.println( f2.format( dateToFormat ) );
      System.out.println( f3.format( dateToFormat ) );
    }
    catch ( ParseException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
