package enthuware.streams;

import java.util.Arrays;
import java.util.List;

public class Primitives {

  public static void main( String[] args ) {
    List<Book> books = Arrays.asList( //
        new Book( "Gone with the wind", 10.0 ), //
        new Book( "Atlas Shrugged", 10.0 ), //
        new Book( "Freedom at Midnight", 5.0 ), //
        new Book( "Gone with the wind", 5.0 ) );
    
    double sum = books.stream()
        .filter( b-> b.getPrice() < 5.0 )
        .mapToInt( b -> (int)b.getPrice() )
        .sum();
    
    System.out.println( sum );
    
    double sum2 = books.stream()
        .mapToDouble( b -> b.getPrice() > 5 ? b.getPrice() : 0.0 )
        .sum();
    
    System.out.println( sum2 );
    
    double sum3 = books.stream()
        .mapToDouble( b -> b.getPrice() )
        .filter( b -> b > 5.0 )
        .sum();
    
    System.out.println( sum3 );

  }

}
