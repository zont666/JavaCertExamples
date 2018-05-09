package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Question5 {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "C:\\Users\\kcarroll\\kang" );
    if ( Files.isDirectory( path ) && Files.isSymbolicLink( path ) ) {
      Files.createDirectory( path.resolve( "joey" ) );
    }

  }

}
