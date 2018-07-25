package enthuware.lambda;

import java.util.function.Function;

public class Functions {

  public static void main( String[] args ) {
    double principle = 100;
    int interestRate = 5;
    double amount = compute( principle, x -> x * interestRate );
    System.out.println( amount );
    double amount2 = compute2( principle, x -> x * interestRate );
    System.out.println( amount2 );

  }

  public static double compute( double base, Function<Integer, Integer> function ) {
    return function.apply( (int)base );
  }

  public static double compute2( double base, Function<Double, Double> function ) {
    return function.apply( base );
  }

}
