package nio_2.paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvingSiblings {

  public static void main( String[] args ) {
    Path path = Paths.get( "/mydir/eWorld.java" );
    Path renamePath = path.resolveSibling( Paths.get( "newWorld.java" ) );
    Path copyPath = path.resolve( "backup/eWorld.java" );
    Path absolutePath = Paths.get( "E:/OCPJavaSE7/" );
    
    System.out.println( "renamePath: " + renamePath );
    System.out.println( "copyPath: " + copyPath );
    System.out.println( "absolutePath: " + absolutePath );
    System.out.println( "path.resolveSibling( \"\" )" + path.resolveSibling( "" ) );
    
    System.out.println( "absolutePath.resolveSibling( path ): " +absolutePath.resolveSibling( path ) );
    System.out.println( "path.resolveSibling( absolutePath ): " + path.resolveSibling( absolutePath ) );

  }

}
