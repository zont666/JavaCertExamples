package enthuware.misc;

import java.util.HashMap;
import java.util.Map;

import enthuware.streams.Book;

public class Generics3 {

  Map<Book, Integer> map = new HashMap<Book, Integer>();

  public Generics3() {
    map.put( new Book( "A111" ), new Integer( 10 ) ); //2    
  }

  public int getNumberOfCopies( Book b ) { //3         
    Integer i = (Integer)map.get( b ); //4         
    return i == null ? 0 : i.intValue(); //5     
  }

  public static void main( String[] args ) {
    // TODO Auto-generated method stub

  }

}
