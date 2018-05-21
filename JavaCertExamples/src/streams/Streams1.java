package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams1 {

  public static void main( String[] args ) {
    //generate
    //    Stream<Double> randoms = Stream.generate( ThreadLocalRandom.current()::nextDouble )//
    //        .limit( 200 );
    //
    //    randoms.forEach( System.out::println );
    //    
    //    System.out.println( randoms );
    //
    //iterate
    //    Stream<Integer> oddNumbers = Stream.iterate( 1, n -> n + 2 );
    //    oddNumbers.forEach( System.out::println );

    //min
    //    Stream<String> s = Stream.of( "monkey", "gorilla", "chimp" );
    //    System.out.println( s.min( (a, b) -> a.toLowerCase().compareTo( b ) ).orElse( "NONE FOUND" ) );
    //    
    //    Optional<?> empty = Stream.empty().min( (a, b) -> 0 );
    //    System.out.println( empty.isPresent() );

    //findAny
    //    Stream<String> s = Stream.of( "monkey", "gorilla", "chimp" );
    //    Stream<String> infinite = Stream.generate( () -> "chimp" );
    //    s.findAny().ifPresent( System.out::println );
    //    infinite.findAny().ifPresent( System.out::println );

    //     List<String> list = Arrays.asList( "monkey", "2", "chimp" );
    //     Stream<String> infinite = Stream.generate( () -> "chimp" );
    //     Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

    //anyMatch/allMatch/noneMatch
    //     System.out.println( list.stream().anyMatch( pred ) );
    //     System.out.println( list.stream().allMatch( pred ) );
    //     System.out.println( list.stream().noneMatch( pred ) );
    //     System.out.println( infinite.noneMatch( pred ) );

    //reduce
    //       Stream<String> stream1 = Stream.of( "m", "o", "n", "k", "e", "y" );
    //       String result1 = stream1.reduce( "", (s1, s2) -> s1 + s2 );
    //       System.out.println( result1 );
    //       
    //       Stream<String> stream2 = Stream.of( "m", "o", "n", "k", "e", "y" );
    //       String result2 = stream2.reduce( "", String::concat );
    //       System.out.println( result2 );

    //         Stream<Integer> streamInts = Stream.of( 1, 3, 5, 7, 8, 10, 20 );
    ////         Integer product = streamInts.reduce( 1, Math::multiplyExact );
    //         Integer product = streamInts.reduce( 1, Math::multiplyExact );
    //         System.out.println( product );

    //    BinaryOperator<Integer> binOp = (a, b) -> a * b;
    //    Stream<Integer> empty = Stream.empty();
    //    Stream<Integer> oneElement = Stream.of( 3 );
    //    Stream<Integer> threeElements = Stream.of( 3, 5, 6 );
    //    
    //    empty.reduce( binOp ).ifPresent( System.out::println );
    //    oneElement.reduce( binOp ).ifPresent( System.out::println );
    //    threeElements.reduce( binOp ).ifPresent( System.out::println );

    //collect
    //    Stream<String> stream = Stream.of( "m", "o", "n", "k", "e", "y" );
    //    StringBuilder word = stream.collect( StringBuilder::new, StringBuilder::append, StringBuilder::append );
    //    System.out.println( word );

    //    Stream<String> stream = Stream.of( "m", "o", "n", "k", "e", "y" );
    //    TreeSet<String> set = stream.parallel().collect( TreeSet::new, TreeSet::add, TreeSet::addAll );
    //    System.out.println( set );

    //    Stream<String> stream = Stream.of( "m", "o", "n", "k", "e", "y" );
    //    Set<String> set = stream.collect( Collectors.toSet() );
    //    System.out.println( set );

    //filter
    //    Stream<String> s = Stream.of( "monkey", "gorilla", "bonobo" );
    //    s.filter( x -> x.startsWith( "m" ) ).forEach( System.out::print );

    //distinct
    //    Stream<String> s = Stream.of( "duck", "duck", "duck", "goose" );
    //    s.distinct().forEach( System.out::println );

    //limit
    //    Stream<Double> stream = Stream.generate( ThreadLocalRandom.current()::nextDouble );
    //    stream.limit( 100 ).forEach( System.out::println );

    //skip
    //    Stream<Integer> stream = Stream.iterate( 1, i -> i + 1 );
    //    stream.skip( 50 ).limit( 100 ).forEach( System.out::println );

    //map
    //    Stream<String> stream = Stream.of( "monkey", "gorilla", "bonobo" );
    //    stream.map( String::length ).forEach( System.out::println );

    //flatMap
    //    List<String> zero = Arrays.asList( );
    //    List<String> one = Arrays.asList( "Bonobo" );
    //    List<String> two = Arrays.asList( "Chimp", "Gorilla" );
    //    List<String> three = Arrays.asList( "Orangutan", "Macaque", "Gibbon" );
    //    
    //    Stream<List<String>> stream = Stream.of( zero, one, two, three );
    //    stream.flatMap( List::stream ).forEach( System.out::println );

    //sorted
    //    Stream<String> s = Stream.of( "brown-", "bear-", "black-", "grizzly-" );
    //    //s.sorted().forEach( System.out::println );
    //    
    //    s.sorted( Comparator.reverseOrder() )
    //    .forEach( System.out::println );

    //peek
    //    Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
    //    long count = stream.filter( s -> s.startsWith( "b" ) )
    //        .peek(  System.out::println ).count();
    //    System.out.println( count );

    //    List<Integer> numbers = new ArrayList<>();
    //    List<Character> letters = new ArrayList<>();
    //
    //    numbers.add( 1 );
    //    letters.add( 'c' );
    //
    //    Stream<List<?>> stream = Stream.of( numbers, letters );
    //    //stream.map( List::size ).forEach( System.out::println );
    //
    //    StringBuilder builder = new StringBuilder();
    //    
    //    //good peek code - doesnt change state of data structure
    //    Stream<List<?>> good = Stream.of( numbers, letters );
    //    good.peek( l -> builder.append( l ) ).map( List::size ).forEach( System.out::println );
    //
    //    //bad peek code - modifies data structure
    //    Stream<List<?>> bad = Stream.of( numbers, letters );
    //    bad.peek( l -> l.remove( 0 ) ).map( List::size ).forEach( System.out::println );

  }

}
