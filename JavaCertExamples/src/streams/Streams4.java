package streams;

import java.util.Optional;

public class Streams4 {

  public static void main( String[] args ) {

    //    //Streams are lazily evaluated
    //    List<String> cats = new ArrayList<>();
    //    cats.add( "Ripley" );
    //    cats.add( "George" );
    //
    //    Stream<String> stream = cats.stream(); // stream isn’t actually created
    //    cats.add( "Blackie" );
    //    System.out.println( stream.count() ); // the stream pipeline actually runs. The stream pipeline runs first, 
    //                                          // looking at the source and seeing three elements
    
    
    //Collecting Results
    

  }

//  private static void threeDigit( Optional<Integer> optional ) {
//    if ( optional.isPresent() ) {
//      Integer num = optional.get();
//      String numAsString = "" + num;
//      if ( numAsString.length() == 3 ) {
//        System.out.println( numAsString );
//      }
//    }
//  }
//
//  private static void threeDigitFunctional( Optional<Integer> optional ) {
//    optional.map( n -> "" + n ) //
//        .filter( s -> s.length() == 3 )//
//        .ifPresent( System.out::println );
//  }

}
