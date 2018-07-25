package enthuware.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class MapMethods {

  Map<String, List<Double>> groupedValues = new HashMap<>();

  public void process( String name, Double value ) {
    groupedValues.computeIfAbsent( name, ( a ) -> new ArrayList<Double>() ).add( value );
  }

  public static void main( String[] args ) {
    Map<String, String> map1 = new HashMap<>();
    map1.put( "a", "x" );
    map1.put( "b", "x" );
    
    BiFunction<String, String, String> f = String::concat;

    map1.merge( "b", "y", f );
    map1.merge( "c", "y", f );
    
    System.out.println( map1 );

  }

}
