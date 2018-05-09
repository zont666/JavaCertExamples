package nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RealPath {

  public static void main( String[] args ) throws IOException {
    Path jdkPath = Paths.get( "C:/java/jdk1.8.0" );
    Path currentDirectory = Paths.get( "." );
    
    
    System.out.println( jdkPath.toRealPath( ) );
    System.out.println( currentDirectory.toRealPath( ) );

  }

}
