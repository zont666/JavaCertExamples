package enthuware.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reductions {

  public static void main( String[] args ) {
    List<Integer> names = Arrays.asList( 1, 2, 3 );

    System.out.println( names.stream().mapToInt( x -> x ).sum() );

    System.out.println( names.stream().reduce( 0, ( a, b ) -> a + b ) );
    
    System.out.println( names.stream().collect( Collectors.summarizingInt( x -> x ) ).getSum() );
    
    System.out.println( names.stream().collect( Collectors.mapping( x -> x, Collectors.summarizingDouble( x -> x ) ) ).getSum() );

  }

}
