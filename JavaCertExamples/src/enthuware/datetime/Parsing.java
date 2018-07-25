package enthuware.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parsing {

  public static void main( String[] args ) {
    LocalDateTime greatDay = LocalDateTime.parse( "2015-01-01T17:13:50" );//2
    String greatDayStr = greatDay.format( DateTimeFormatter.ISO_DATE_TIME ); //3         
    System.out.println(greatDayStr);//4

  }

}
