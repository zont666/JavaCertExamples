package enthuware.streams;

import java.util.Optional;

public class Optionals {

  public static void main( String[] args ) {
    Optional<Double> price = Optional.ofNullable( getPrice( "1111" ) );
    Double x = price.orElse( getPrice( "2222" ) );

    Optional<Double> price2 = Optional.ofNullable( getPrice( "1111" ) );
    Double y = price.orElseGet( () -> getPrice( "333" ) );

  }

  public static Double getPrice( String id ) {
    return null;
  }

}
