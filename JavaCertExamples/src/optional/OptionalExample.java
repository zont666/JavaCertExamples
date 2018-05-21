package optional;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class OptionalExample {

  public static void main( String[] args ) throws Exception {
    
    Optional<Double> opt = average(1, 2, 3, 4, 5);
    
    if(opt.isPresent())
      System.out.println( "Its present : " + opt.get() );
        
    opt.ifPresent( System.out::println );
    
    Double random = average().orElse( ThreadLocalRandom.current().nextDouble() );
    System.out.println( "random: " + random );
    
    
    
    random = average(null).orElseGet( ThreadLocalRandom.current()::nextDouble  );
    System.out.println( "another random: " + random );
    
    //average(null).orElseThrow( IllegalStateException::new );
    //average(null).orElseThrow( () -> new IllegalStateException() );
    
    System.out.println( average(1, 2, 3, 4, 5) );
    System.out.println( average() );
    System.out.println( average(null) );
    
    
    System.out.println( Optional.empty().orElse( Double.NaN ) );
    
    
    System.out.println(Optional.ofNullable( null )  );
    
    

  }

  static Optional<Double> average( int ... values ) {
    if ( values == null || values.length == 0  ) {
      return Optional.empty();
    }

    int sum = 0;

    for ( int value : values ) {
      sum += value;
    }

    Double average = (double)(sum / values.length);

    return Optional.of( average );

  }
  
  static Double randomDouble() {
    return Double.valueOf( ThreadLocalRandom.current().nextDouble() );
  }
  
  public static <T> Optional<T> empty() {
    @SuppressWarnings("unchecked")
    Optional<T> t = (Optional<T>) Optional.empty();
    return t;
}

}
