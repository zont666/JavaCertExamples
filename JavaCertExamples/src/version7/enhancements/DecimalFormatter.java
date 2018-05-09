package version7.enhancements;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatter {

  public static void main( String[] args ) {
    double decimalNumber = 123_456_7.437;
    
    DecimalFormat decimalFormat1 = new DecimalFormat( "###, ###, ###.###" );
    System.out.println( decimalFormat1.format( decimalNumber ) );
    
    DecimalFormat decimalFormat2 = new DecimalFormat( "000,000,000.00000" );
    System.out.println( decimalFormat2.format( decimalNumber ) );
    
    DecimalFormat decimalFormat3 = new DecimalFormat( "$#,###,###.##" );
    System.out.println( decimalFormat3.format( decimalNumber ) );
    
    
    //Other methods using Factory methods
    System.out.println( NumberFormat.getCurrencyInstance().format( decimalNumber ) );    
    System.out.println( NumberFormat.getCurrencyInstance(Locale.US).format( decimalNumber ) );
    System.out.println( NumberFormat.getPercentInstance().format( decimalNumber ) );
  }

}
