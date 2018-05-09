package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryListing {

  public static void main( String[] args ) {
    Path path = Paths.get( ".\\animals\\" );
    try {
      Files.list( path ) //
          .filter( p -> !Files.isDirectory( p ) ) //
          .map( Path::toAbsolutePath ) //
          .forEach( System.out::println );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
