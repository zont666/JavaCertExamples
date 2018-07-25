package enthuware.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Misc {

  public static void main( String[] args ) {
    List<String> letters = Arrays.asList("j", "a", "v","a");
    UnaryOperator<String> uo = str -> str.toUpperCase();
    letters.replaceAll( uo );
    letters.forEach( System.out::print );
    
    System.out.println(  );
    letters = Arrays.asList("j", "a", "v","a");
    letters.forEach( x -> System.out.print( x.toUpperCase()  ) );
    
    System.out.println(  );
    letters = Arrays.asList("j", "a", "v","a");
    System.out.println( letters.stream().collect( Collectors.joining() ).toUpperCase() );
  }

}
