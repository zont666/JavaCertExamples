package enthuware.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;

public class DoubleFunctionExample {

  public static void main( String[] args ) {
    List<Double> dList = Arrays.asList( 10.0, 12.0 );
    DoubleFunction df = x -> x + 10;
    dList.stream().forEach( d -> System.out.println( d ) );

  }

}
