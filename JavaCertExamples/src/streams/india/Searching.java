package streams.india;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Searching {

  public static void main( String[] args ) {
    boolean anyMatch = DoubleStream.of( -56.0, -57.0, -55.0, -52.0, -48.0, -51.0, -49.0 ).anyMatch( t -> t > 0 );
    System.out.println( anyMatch );
    
    boolean allMatch = DoubleStream.of( -56.0, -57.0, -55.0, -52.0, -48.0, -51.0, -49.0 ).allMatch( t -> t > 0 );
    System.out.println( allMatch );
    
    boolean noneMatch = DoubleStream.of( -56.0, -57.0, -55.0, -52.0, -48.0, -51.0, -49.0 ).noneMatch( t -> t > 0 );
    System.out.println( noneMatch );
    
    
    Method[] methods = Stream.class.getMethods();
    Optional<String> methodName = Arrays.stream( methods ).parallel()
        .map( method -> method.getName() )
        .filter( name -> name.endsWith( "Match" ) )
        .sorted()
        .findAny();
    System.out.println( methodName.orElse( "No suitable method found" ) );
    
    
    OptionalDouble optDoub = DoubleStream.of( -56.0, -57.0, -55.0, -52.0, -48.0, -51.0, -49.0 ).findAny();
    System.out.println( optDoub.getAsDouble() );
    
    System.out.println( DoubleStream.of( -56.0, -57.0, -55.0, -52.0, -48.0, -51.0, -49.0 ).max() );
    
    System.out.println( Stream.of(  ).findAny() );
  }

}
