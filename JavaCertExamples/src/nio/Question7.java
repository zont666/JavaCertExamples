package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Question7 {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "" );
    System.out.println( path.toAbsolutePath() );
    if ( !Files.isSameFile( path, Paths.get( ".\\animals\\test" ) ) ) {
      Files.createDirectory( path.resolve( "zzzz" ) );
    }

  }

}
