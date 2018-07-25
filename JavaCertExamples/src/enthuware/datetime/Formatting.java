package enthuware.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatting {

  public static void main( String[] args ) {
    SimpleDateFormat sdf = new SimpleDateFormat( "zzzz" );
    System.out.println( sdf.format( new Date() ) );
    
    
    Date d = new Date();
    DateFormat df = DateFormat.getDateInstance( DateFormat.DEFAULT, Locale.UK );
    String s = df.format( d );
    System.out.println( s  );
  }

}
