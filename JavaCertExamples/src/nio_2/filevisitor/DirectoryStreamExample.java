package nio_2.filevisitor;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamExample {

  public static void main( String[] args ) {
    Path path = Paths.get( "." );
    try (DirectoryStream<Path> stream = Files.newDirectoryStream( path )) {
      for ( Path value : stream ) {
        System.out.println( value + " : " + Files.isDirectory( value ) );
      }
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
