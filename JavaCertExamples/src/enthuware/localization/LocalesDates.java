package enthuware.localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LocalesDates {

  public static void main( String[] args ) {
    Locale l = Locale.getDefault();
    DateFormat df = DateFormat.getDateInstance();
    System.out.println( l.getCountry() + " " + df.format( new Date() ) );

  }

}
