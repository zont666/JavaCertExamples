package datetime.india;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Formatting {

  public static void main( String[] args ) {
    LocalTime wakeUpTime = LocalTime.of( 7, 0, 0 );
    System.out.println( DateTimeFormatter.ISO_TIME.format( wakeUpTime ) );

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter customFormat = DateTimeFormatter.ofPattern( "hh:mm:ss    E dd MMMM" );
    System.out.println( customFormat.format( now ) );

    String[] dateTimeFormats = //
        { "dd-MM-yyyy", /* d is day (in month), M is month, y is year */
            "d '('E')' MMM, YYYY", /*E is name of the day (in week), Y is year*/
            "w'th week of' YYYY", /* w is the week of the year */
            "EEEE, dd'th' MMMM, YYYY" /*E is day name in the week */
        };

    for ( String dateTimeFormat : dateTimeFormats ) {
      System.out.printf( "Pattern \"%s\" is %s %n ", dateTimeFormat, DateTimeFormatter.ofPattern( dateTimeFormat ).format( now ) );
    }

    
    LocalTime timeNow = LocalTime.now();
    String[] timeFormats = { "h:mm", /* h is hour in am/pm (1-12), m is minute */
        "hh 'o''clock'", /* '' is the escape sequence to print a single quote */
        "H:mm a", /* H is hour in day (0-23), a is am/pm*/
        "hh:mm:ss:SS", /* s is seconds, S is milliseconds */
        "K:mm:ss a" /* K is hour in am/pm(0-11) */
    };
    for ( String timeFormat : timeFormats ) {
      System.out.printf( "Time in pattern \"%s\" is %s %n", timeFormat, DateTimeFormatter.ofPattern( timeFormat ).format( timeNow ) );
    }

  }

}
