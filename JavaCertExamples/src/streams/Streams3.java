package streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams3 {

  public static void main( String[] args ) {
    //    Stream<Integer> s = Stream.of( 1, 2, 3, 4, 5 );
    //    //    Integer result = s.reduce( 0, ( a, b ) -> a + b );
    //    //Integer result = s.reduce( 0, Integer::sum );

    //Primitive Streams
    //    Integer result = s.mapToInt( x -> x ).sum();
    //    System.out.println( result );

    //    IntStream intStream = IntStream.of(1, 2, 3);
    //    OptionalDouble avg = intStream.average();
    //    System.out.println(avg.getAsDouble());

    //    DoubleStream empty = DoubleStream.empty();
    //    DoubleStream oneValue = DoubleStream.of( 3.14 );
    //    DoubleStream varargs = DoubleStream.of( 1.0, 1.1, 1.2 );
    //    
    //    oneValue.forEach( System.out::println );
    //    System.out.println(  );
    //    varargs.forEach( System.out::println );

    //    DoubleStream random = DoubleStream.generate( ThreadLocalRandom.current()::nextDouble );
    //    DoubleStream fractions = DoubleStream.iterate( 0.5, d -> d / 2 );
    //    random.limit( 10 ).forEach( System.out::println );
    //    System.out.println(  );

    //Range
    //    IntStream ints = IntStream.iterate( 1,  n -> n + 1 ).limit( 5 );
    //    ints.forEach( System.out::println );

    //IntStream.range( 1, 6 ).forEach( System.out::println );
    //    IntStream.rangeClosed( 1, 5 ).forEach( System.out::println );

    //Mapping between different stream types
    //    Stream<String> objStream = Stream.of( "penguin", "fish" );
    //    IntStream intStream = objStream.mapToInt( String::length );
    //    intStream.forEach( System.out::println );

    //    IntStream stream = IntStream.rangeClosed( 1,  10 );
    //    OptionalDouble optional = stream.average();
    //    System.out.println( optional.getAsDouble() );

    //    LongStream longs = LongStream.of( 5, 10 );
    //    long sum = longs.sum();
    //    System.out.println( sum );

    //Runs infinitely
    //    DoubleStream doubles = DoubleStream.generate( () -> Math.PI );
    //    OptionalDouble min = doubles.min();

    //Summarising statistics - also available for Long, Double
//    IntStream ints = IntStream.of( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
//    IntSummaryStatistics stats = ints.summaryStatistics();
//    System.out.println( stats );
    
    //BooleanSupplier
    BooleanSupplier b1 = () -> true;
    BooleanSupplier b2 = () -> Math.random() > 0.5;
    
    System.out.println( b1.getAsBoolean() );
    System.out.println( b2.getAsBoolean() );

  }

}
