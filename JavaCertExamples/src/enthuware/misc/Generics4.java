package enthuware.misc;

import java.util.ArrayList;
import java.util.List;

public class Generics4 {

  public static void main( String[] args ) {
    
    ArrayList<String> in = new ArrayList<>(); 
    List<? super String> result;
    
    result = doIt(in);

  }

  public static <E extends CharSequence> List<? super E> doIt( List<E> nums ) {
    return nums;

  }

}
