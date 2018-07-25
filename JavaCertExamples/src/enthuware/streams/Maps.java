package enthuware.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Maps {

  public static void main( String[] args ) {
    List<Book> books = Arrays.asList( //
        new Book( "Gone with the wind", 5.0 ), //
        new Book( "Gone with the wind", 10.0 ), //
        new Book( "Atlas Shrugged", 15.0 ) //
    );
    
    books.stream().collect( Collectors.toMap( Book::getTitle, Book::getPrice, (v1, v2) -> v1 +  v2 ) );

  }

}
