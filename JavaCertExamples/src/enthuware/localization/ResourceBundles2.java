package enthuware.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles2 {

  public static void main( String[] args ) {
    Locale locale = new Locale( "en", "US" );
    ResourceBundle rb = ResourceBundle.getBundle( "test.MyBundle", locale );

    Object obj = rb.getObject( "key1" );
    String[] vals = rb.getStringArray( "key2" );

  }

}
