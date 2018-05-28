package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Questions {

  public static void main( String[] args ) {
    //Q1
    //System.out.println( stream.limit( 2 ).map( x -> x + "2" ) );

    //Q2
    //    Predicate<? super String> predicate = s -> s.startsWith( "g" );
    //    Stream<String> stream1 = Stream.generate( () -> "growl! " );
    //    Stream<String> stream2 = Stream.generate( () -> "growl! " );
    //    
    //    boolean b1 = stream1.anyMatch( predicate );
    //    //boolean b2 = stream2.allMatch( predicate );
    //    boolean b2 = stream2.noneMatch( predicate );
    //    System.out.println( b1 + " " + b2 );

    //Q3
    //    Predicate<? super String> predicate = s -> s.length() > 3;
    //    Stream<String> stream = Stream.iterate( "-", ( s ) -> s + s );
    //    boolean b1 = stream.noneMatch( predicate );
    //    boolean b2 = stream.anyMatch( predicate );
    //    System.out.println( b1 + " " + b2 );

    //Q6
//    Stream<String> s = Stream.generate( () -> "meow" );
//    boolean match = s.allMatch( String::isEmpty );
//    System.out.println( match );
    
    //Q11
//    System.out.println( Stream.iterate( 1, x -> ++x ).limit( 5 ).map( x -> "" + x ).collect( Collectors.joining() ) );
    
    //Q13
//    List<Integer> l1 = Arrays.asList(1, 2, 3);
//    List<Integer> l2 = Arrays.asList(4, 5, 6);
//    List<Integer> l3 = Arrays.asList();
//    Stream.of(l1, l2, l3).flatMap( x -> x.stream() ).map( x -> x + 1).forEach( System.out::print );
    
    //Q14
//    Stream<Integer> s = Stream.of(1);
//    IntStream is = s.mapToInt( x -> x );
//    DoubleStream ds = s.mapToDouble( x -> x );
//    ds.mapToInt( x -> x );
    

  }

}
