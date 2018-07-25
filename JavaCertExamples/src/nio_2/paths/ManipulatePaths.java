package nio_2.paths;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManipulatePaths {

  public static void main( String[] args ) {
    Path path = FileSystems.getDefault().getPath( "c:\\users\\obj8\\8-1.txt" );

    System.out.println( "toString() : " + path.toString() );
    System.out.println( "getRoot() : " + path.getRoot() );
    System.out.println( "getName() : " + path.getName( 0 ) );
    System.out.println( "getName() : " + path.getName( 1 ) );
    System.out.println( "getFileName() : " + path.getFileName() );
    System.out.println( "getNameCount() : " + path.getNameCount() );
    System.out.println( "getFileSystem() : " + path.getFileSystem() );
    System.out.println( "getParent() : " + path.getParent() );
    System.out.println( "subpath() : " + path.subpath( 0, 2 ) );

    System.out.println( "startsWith() : " + path.startsWith( "c:\\users\\" ) );
    System.out.println( "endsWith() : " + path.endsWith( "8-1.txt" ) );

    System.out.println( "startsWith() using Path : " + path.startsWith( Paths.get( "c:\\users\\" ) ) );
    System.out.println( "endsWith() using Path : " + path.endsWith( Paths.get( "8-1.txt" ) ) );
    
    
    
  }

}
