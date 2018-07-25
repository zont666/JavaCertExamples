package enthuware.localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles {

  public static void main( String[] args ) {
    Locale myLocale = new Locale.Builder().setLanguage( "en" ).setRegion( "UK" ).build();
    ResourceBundle msgs = ResourceBundle.getBundle( "resources.mymsgs", myLocale );
    
    Enumeration<String> en = msgs.getKeys();
    
    while(en.hasMoreElements()) {
      String key = en.nextElement();
      String val = msgs.getString( key );
      System.out.println( key + " : " + val );
    }

  }

}
