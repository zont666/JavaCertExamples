package optional.india;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

public class NullableBook {

  Optional<String> bookName;

  public NullableBook( Optional<String> name ) {
    bookName = name;
  }

  public Optional<String> getName() {
    return bookName;
  }

  public static void main( String[] args ) {
    NullableBook nullBook = new NullableBook( Optional.ofNullable( null ) );
    Optional<String> name = nullBook.getName();
    if ( name.isPresent() )
      System.out.println( name.get() );

  }

}
