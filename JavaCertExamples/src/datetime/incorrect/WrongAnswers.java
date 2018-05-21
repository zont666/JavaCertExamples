package datetime.incorrect;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class WrongAnswers {

  public static void main( String[] args ) {
    LocalDateTime d = LocalDateTime.of( 2015, 5, 10, 11, 22, 33 );
    Period p = Period.of( 1, 2, 3 );

    d = d.minus( p );

    DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime( FormatStyle.SHORT );
    System.out.println( d.format( f ) );

    System.out.printf( "%n%n%n%n" );

    Period p2 = Period.ofDays( 1 );

    System.out.println( p2 );

    System.out.printf( "%n%n%n%n" );

    String m1 = Duration.of( 1, ChronoUnit.MINUTES ).toString();
    System.out.println( m1 );

    String m2 = Duration.ofMinutes( 1 ).toString();
    System.out.println( m2 );

    System.out.println( m1 == m2 );
    System.out.println( m1.equals( m2 ) );
    
    String s = Duration.of( 60, ChronoUnit.SECONDS ).toString();
    System.out.println( s );
    System.out.println( m1.equals( s ) );
    
    String dd = Duration.ofDays( 1 ).toString();
    System.out.println( dd );
    
    String pp = Period.ofDays( 1 ).toString();
    System.out.println( pp );
    

  }

}
