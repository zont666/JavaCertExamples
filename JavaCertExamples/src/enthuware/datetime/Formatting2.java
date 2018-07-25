package enthuware.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatting2 {

  public static void main( String[] args ) {
    //Needs to be ZonedDateTime
    System.out.println( DateTimeFormatter.ISO_ZONED_DATE_TIME.format( LocalDateTime.now() ) );

  }

}
