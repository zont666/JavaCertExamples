package enthuware.streams;

import java.util.Optional;

public class AnotherOptionalExample {

  public static void main( String[] args ) {
    Optional<String> stro = Optional.ofNullable( null );
    System.out.println( stro.isPresent() );
    System.out.println( stro.get() );
    System.out.println( stro.orElse( null ) );

  }

}
