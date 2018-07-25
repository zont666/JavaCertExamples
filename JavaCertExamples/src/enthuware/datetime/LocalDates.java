package enthuware.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDates {

  public static void main( String[] args ) {
    LocalDate d1 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_DATE);
    System.out.println(d1);

  }

}
