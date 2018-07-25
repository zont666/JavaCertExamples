package enthuware.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics2 {

  public static void main( String[] args ) {
    String[] p = { "1", "2", "3" };
    List<?> list2 = new ArrayList<>( Arrays.asList( p ) );

    //Wrong type parameter specified on right side - should be String
    //List<?> list3 = new ArrayList<Integer>(Arrays.asList(p));

    ///Wrong type parameter specified on left side - should be String
    //List<Integer> list4 = new ArrayList<>(Arrays.asList(p));

    List<? super Number> numbers = new ArrayList<>();
    numbers.add( new Double( 10.0 ) );
    numbers.add( new Long( 10L ) );
    numbers.add( new Integer( 10 ) );
    //numbers.add( new Object() );
    for ( Object number : numbers ) {
      System.out.println( number.getClass() );
    }
    
    List<? extends Long> moreNumbers = new ArrayList<>();

    
  }

}
