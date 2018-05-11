package datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parsing {

  public static void main( String[] args ) {
    System.out.println( LocalDate.parse( "2018-05-03" ) );
    
    System.out.println( LocalDate.parse( "20180503", DateTimeFormatter.BASIC_ISO_DATE ) );
    
    System.out.println( LocalDate.parse( "Jun 23 2003", DateTimeFormatter.ofPattern( "MMM d yyyy" ) ) );

  }

}
