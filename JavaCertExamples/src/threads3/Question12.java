package threads3;

import java.util.Arrays;

public class Question12 {

  public static void main( String[] args ) {
    System.out.println( Arrays.asList( "duck", "chicken", "flamingo", "pelican" ) //
        .parallelStream() //
        .parallel() //
        .reduce( 0, //
            (c1, c2) -> c1 + c2.length(), //
            (s1, s2) -> s1 + s2) );
  }

}
