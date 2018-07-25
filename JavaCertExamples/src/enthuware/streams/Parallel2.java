package enthuware.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parallel2 {

  public static void main( String[] args ) {
    ArrayList<Integer> source = new ArrayList<Integer>();
    source.addAll( Arrays.asList( 1, 2, 3, 4, 5, 6 ) );

    List<Integer> destination = Collections.synchronizedList( new ArrayList<Integer>() );
    source.parallelStream() //1         
        .peek( item -> destination.add( item ) ) //2         
        .forEachOrdered( System.out::print );

    System.out.println( "" );

    destination.stream() //3          
        .forEach( System.out::print ); //4 
    System.out.println( "" );

  }

}
