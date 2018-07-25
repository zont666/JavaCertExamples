package enthuware.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy2 {

  public static void main( String[] args ) {
    List<Book> books = Arrays.asList( //
        new Book( "There is a hippy on the highway", "Thriller", "James Hadley Chase" ), //
        new Book( "Coffin from Hongkong", "Thriller", "James Hadley Chase" ), //
        new Book( "The Client", "Thriller", "John Grisham" ), //
        new Book( "Gone with the wind", "Fiction", "Margaret Mitchell" ) );
    Map<String, Map<String, List<Book>>> classified = books.stream() //
        .collect( Collectors.groupingBy( Book::getGenre, Collectors.groupingBy( Book::getAuthor ) ) );
    System.out.println( classified );
  }

}
