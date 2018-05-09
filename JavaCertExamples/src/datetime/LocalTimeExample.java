package datetime;

import java.time.LocalTime;

public class LocalTimeExample {

  public static void main( String[] args ) {
    LocalTime thisSec;

    for ( ;; ) {
      thisSec = LocalTime.now();
      
      System.out.println( thisSec.getHour() + ":" + thisSec.getMinute() + ":" + thisSec.getSecond() + ":::" + thisSec.getNano() );
    }

  }

}
