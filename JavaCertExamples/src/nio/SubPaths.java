package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SubPaths {

  public static void main( String[] args ) {
    Path path = Paths.get( "/mammal/carnivore/raccoon.image" );
    System.out.println( "Path is: " + path );
    
    System.out.println( path.subpath( 0, 3 ) );
    System.out.println( path.subpath( 1, 3 ) );
    System.out.println( path.subpath( 1, 2 ) );
  }

}
