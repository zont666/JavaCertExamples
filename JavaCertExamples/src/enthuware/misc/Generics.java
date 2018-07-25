package enthuware.misc;

import java.util.ArrayList;
import java.util.List;

public class Generics {

  public static void main( String[] args ) {
    // TODO Auto-generated method stub

  }

  class Shape {

  }

  public List<? extends Shape> m4( List<? extends Shape> strList ) {
    List<Shape> list = new ArrayList<>();
    list.add( new Shape() );
    list.addAll( strList );
    return list;
  }

  public void m5( ArrayList<? extends Shape> strList ) {
    List<Shape> list = new ArrayList<>();
    list.add( new Shape() );
    list.addAll( strList );
  }

  /**
   * strList and list both are Lists of some class that extends from Shape. 
   * However, the compiler does not know which class(es). 
   * Therefore, you cannot add contents of strList to list or vice-versa.
   */
//  public List<Shape> m3( ArrayList<? extends Shape> strList ) {
//    List<? extends Shape> list = new ArrayList<>();
//    list.addAll( strList );
//    return list;
//  }
  
  /**
   * list is a List of some class that extends from Shape. 
   * It may not necessarily be Shape. 
   * Therefore, you cannot add a Shape to list. 
   * But you can add all the elements of list to strList.
   */
//  public void m6(ArrayList<Shape> strList) {
//    List<? extends Shape> list = new ArrayList<>();
//    list.add( new Shape() );
//    strList.addAll( list );
//  }

}
