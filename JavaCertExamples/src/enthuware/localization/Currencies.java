package enthuware.localization;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

public class Currencies {

  public static void main( String[] args ) {
    double amount = 53000.35;
    Locale jp = new Locale( "jp", "JP" );

    Format formatter = NumberFormat.getCurrencyInstance( jp );
    NumberFormat formatter2 = DecimalFormat.getCurrencyInstance( jp );

    System.out.println( formatter.format( amount ) );
    System.out.println( formatter2.format( amount ) );

  }

}
