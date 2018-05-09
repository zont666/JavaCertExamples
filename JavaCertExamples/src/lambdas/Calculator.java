package lambdas;

public class Calculator {

  @FunctionalInterface
  interface IntegerMath {
    int operation( int a, int b );
  }

  public int operateBinary( int a, int b, IntegerMath op ) {
    return op.operation( a, b );

  }

  public static void main( String[] args ) {
    Calculator calc = new Calculator();
    IntegerMath addition = ( a, b ) -> a + b;
    IntegerMath subtraction = ( a, b ) -> a - b;
    IntegerMath multiplication = ( a, b ) -> a * b;
    
    System.out.println( calc.operateBinary( 40, 2, addition ) );
    System.out.println( calc.operateBinary( 40, 2,  subtraction) );
    System.out.println( calc.operateBinary( 40, 2, multiplication ) );

  }

}
