package enthuware.streams;

import java.util.Arrays;
import java.util.List;

public class CalculatingMax {

  public static void main( String[] args ) {
    List<Integer> ls = Arrays.asList( 3, 4, 6, 9, 2, 5, 7 );

    System.out.println( ls.stream().reduce( Integer.MIN_VALUE, ( a, b ) -> a > b ? a : b ) ); //1 
    System.out.println( ls.stream().max( Integer::max ).get() ); //2 
    System.out.println( ls.stream().max( Integer::compare ).get() ); //3 
    System.out.println( ls.stream().max( ( a, b ) -> a > b ? a : b ) ); //
    
    
    System.out.println("\nUSING Integer.max()\n");
    System.out.println(ls.stream().max((o1, o2) -> {System.out.print("\no1: " +o1);
                                                    System.out.print(", o2: " +o2);
                                                    int max = Integer.max(o1, o2);
                                                    System.out.print(", max: "+max);
                                                    System.out.print("\t");
                                                    return max;})
                                  .get());
    System.out.println("\nUSING Integer.compare()\n");
    System.out.println(ls.stream().max((o1, o2) -> {System.out.print(o1);
                                                    System.out.print(o2);
                                                    int max = Integer.compare(o1, o2);
                                                    System.out.print(max);
                                                    System.out.print("\t");
                                                    return max;})
                                  .get());

  }

}
