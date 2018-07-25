package enthuware.lambda;

import java.util.function.Function;

public class EffectivelyFinal {

  public static void main( String[] args ) {
    // TODO Auto-generated method stub

  }

  public static double process( double payment, int rate ) {
    double defaultrate = 0.10; //1      
    //if ( rate > 10 )      defaultrate = rate; //2      
    class Implement {
      public int apply( double data ) {
        Function<Integer, Integer> f = x -> x + (int)(x * defaultrate); //3
        return f.apply( (int)data ); //4    
      }
    }
    Implement i = new Implement();
    return i.apply( payment );
  }

}
