package enthuware.streams;

import java.util.Arrays;
import java.util.List;

public class FlatMap {

  public static void main( String[] args ) {
    List<List<Book>> books = Arrays.asList( //
        Arrays.asList( //
            new Book( "Windmills of the Gods", 7.0 ), //
            new Book( "Tell me your dreams", 9.0 ) //
        ), //
        Arrays.asList( //
            new Book( "There is a hippy on the highway", 5.0 ), //
            new Book( "Easy come easy go", 5.0 ) //
        ) //
    );

    double d = books.stream().flatMap( List::stream ).mapToDouble( Book::getPrice ).sum();

    System.out.println( d );

  }

}
