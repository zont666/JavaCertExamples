package threads2;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class CallableExample {

  public static void useCallable( Callable<Integer> expression ) {
  }

  public static void useSupplier( Supplier<Integer> expression ) {
  }

  public static void use( Supplier<Integer> expression ) {
  }

  public static void use( Callable<Integer> expression ) {
  }

  public static void main( String[] args ) {
    useCallable( () -> {
      throw new IOException();
    } );

    /*
    useSupplier( () -> {
      throw new IOException();
    } );
     */

    //Need explicit cast when lambda is ambiguous
    use( (Callable<Integer>)() -> {
      throw new IOException();
    } );
  }

}
