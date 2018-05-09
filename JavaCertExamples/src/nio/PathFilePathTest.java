package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFilePathTest {

  public static void main( String[] args ) {
    printPathInfo( Paths.get( "/zoo/armadillo/shells.txt" ) );
    System.out.println(  );
    printPathInfo( Paths.get( "armadillo/shells.txt" ) );
  }

  public static void printPathInfo( Path path ) {
    System.out.println( "Filename is: " + path.getFileName() );
    System.out.println( "Root is: " + path.getRoot() );

    Path currentPath = path;

    while ( (currentPath = currentPath.getParent()) != null ) {
      System.out.println( "Current parent is: " + currentPath );
    }
  }

}
