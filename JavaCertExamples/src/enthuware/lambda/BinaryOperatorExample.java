package enthuware.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

  public static void main( String[] args ) {
    BinaryOperator<String> bo = String::concat;
    List<String> names = new ArrayList<>();
    names.add( "Bill" );
    names.add( "George" );
    names.add( "Obama" );
    
    String finalValue = names.stream().reduce( "Hello", bo );
    System.out.println( finalValue );
  }

}
