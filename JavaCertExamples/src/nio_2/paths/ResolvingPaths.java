package nio_2.paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvingPaths {

  public static void main( String[] args ) {
    Path path = Paths.get( "/mydir/code" );

    System.out.println( path.resolve( Paths.get( "world/Hello.java" ) ) );
    System.out.println( path.resolve( "/world/Hello.java" ) );

    Path absolutePath = Paths.get( "E:/OCPJavaSE7/" );
    System.out.println( absolutePath.resolve( path ) );
    System.out.println(path.resolve( absolutePath ));
    
    
    System.out.println( "\n\n\n\n" );
  }

}
