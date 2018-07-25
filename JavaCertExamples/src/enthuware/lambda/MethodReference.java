package enthuware.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

  public static void main( String[] args ) {
    Supplier<MyProcessor> supplier = MyProcessor::new;
    MyProcessor mp = supplier.get();
    mp.process();
    
    Function<Integer, MyProcessor> function = MyProcessor::new;
    MyProcessor mp2 = function.apply( 10 );
    mp2.process();

  }

  static class MyProcessor {
    int value;

    public MyProcessor() {
      value = 10;
    }

    public MyProcessor( int value ) {
      this.value = value;
    }

    public void process() {
      System.out.println( "Processing " + value );
    }
  }

}
