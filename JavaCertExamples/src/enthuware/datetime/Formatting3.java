package enthuware.datetime;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Formatting3 {

  public static void main( String[] args ) throws ParseException {
    double amount = 123456.789;
    Locale fr = new Locale( "fr", "FR" );
    NumberFormat formatter = NumberFormat.getInstance( fr );
    String s = formatter.format( amount );
    formatter = NumberFormat.getInstance();
    Number amount2 = formatter.parse( s );
    System.out.println( amount + " " + amount2 );

  }

}
