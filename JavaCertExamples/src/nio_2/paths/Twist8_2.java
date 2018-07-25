package nio_2.paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Twist8_2 {

  public static void main( String[] args ) {
    Path dir = Paths.get( "code" );
    Path file = Paths.get( "code/java/IO.java" );

    Path relativizedPath = file.relativize( dir );

    Path resolvedPath = file.resolve( relativizedPath );
    Path absolute = resolvedPath.toAbsolutePath();
    
    System.out.println( "relativizedPath: " + relativizedPath );
    System.out.println( "resolvedPath: " + resolvedPath );
    System.out.println( "absolute: " + absolute );

  }

}
