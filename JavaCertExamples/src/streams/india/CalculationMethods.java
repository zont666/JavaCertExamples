package streams.india;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CalculationMethods {

  public static void main( String[] args ) {
    String[] string = "you never know what you have until you clean your room".split( " " );
    Optional<String> optString = Arrays.stream( string ).min( String::compareTo );
    System.out.println( optString.get() );
    
    String[] string2 = "you never know what you have until you clean your room".split( " " );
    Optional<String> optString2 = Arrays.stream( string ).max( (s1, s2) -> s1.length() - s2.length() );
    System.out.println( optString2.get() );
    
    String limerick = "There was a young lady named Bright " +
        "who traveled much faster than light " +
        "She set out one day " +
        "in a relative way " +
        "and came back the previous night ";
    
    IntSummaryStatistics wordStatistics = Pattern.compile( " " )
        .splitAsStream( limerick )
        .mapToInt( s -> s.length() )
        .summaryStatistics();
    
    System.out.printf(" Number of words = %d \n "
        + "Sum of the length of the words = %d \n" +
        " Minimum word size = %d \n "
        + "Maximum word size %d \n " +
        " Average word size = %f \n", 
        wordStatistics.getCount(),
        wordStatistics.getSum(), 
        wordStatistics.getMin(),
        wordStatistics.getMax(), 
        wordStatistics.getAverage());
    
    System.out.println( "wordStatistics : " + wordStatistics );
    
    
    int total = IntStream.of( 10, 20, 30, 40, 50 ).reduce( 0, (sum, val) -> sum + val );
    System.out.println( total );
    
    
    System.out.println( IntStream.rangeClosed( 1,  5 ).reduce( ( x, y )  -> (x * y)).getAsInt() );
    
  }

}
