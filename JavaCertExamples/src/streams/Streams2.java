package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams2 {

  public static void main( String[] args ) {
//    List<String> list = Arrays.asList( "Toby", "Anna", "Leroy", "Alex" );
//
//    list.stream() //
//        .filter( s -> s.length() == 4 ) //
//  .sorted() //
//        .limit( 2 ) //
//        .forEach( System.out::println );
    
//    Stream.generate( () -> "Elsa" ) //
//    .filter( n -> n.length() == 4 ) //
//    .sorted() //
//    .limit( 2 ) //
//    .forEach( System.out::println ); // HANGS!!!!
    
//    Stream.generate( () -> "Elsa" ) //
//    .filter( n -> n.length() == 4 ) //
//    .limit( 2 ) //
//    .sorted() //
//    .forEach( System.out::println ); // Elsa Elsa
    
//    Stream.generate(() -> "Olaf Lazisson")
//    .filter(n -> n.length() == 4)
//    .limit(2)
//    .sorted()
//    .forEach(System.out::println); // HANGS!!!!
    
//    Stream<Integer> infinite = Stream.iterate( 1,  x -> x + 1 );
//    infinite.limit( 5 )
//    .filter( x -> x % 2 == 1 )
//    .forEach( System.out::println ); // 135
//    
//    Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
//    infinite.limit(5)
//    .peek(System.out::print)
//    .filter(x -> x % 2 == 1)
//    .forEach(System.out::print); // 11233455
    
//    Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
//    infinite.filter(x -> x % 2 == 1)
//    .limit(5)
//    .forEach(System.out::print); // 13579
    
//    Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
//    infinite.filter(x -> x % 2 == 1)
//    .peek(System.out::print)
//    .limit(5)
//    .forEach(System.out::print); // 1133557799

  }

}
