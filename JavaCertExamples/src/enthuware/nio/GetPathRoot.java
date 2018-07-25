package enthuware.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class GetPathRoot {

  public static void main( String[] args ) {
    Path p1 = Paths.get( "c:\\\\code\\\\java\\\\PathTest.java" );
    System.out.println( p1.getRoot() );
    System.out.println( p1.getName( 0 ) );
    System.out.println( p1.getName( 1 ) );
    System.out.println( p1.getName( 2 ) );
    System.out.println( p1.getName( 3 ) );
  }

}
