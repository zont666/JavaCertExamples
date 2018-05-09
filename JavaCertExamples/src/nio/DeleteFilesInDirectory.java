package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFilesInDirectory {

  private static void deleteContentsOfDirectory( Path directory ) {
    try {
      Files.list( directory )//
          .forEach( p -> {
            try {
              if ( Files.isRegularFile( p ) ) {
                Files.delete( p );
              }
              else {
                deleteContentsOfDirectory( p );
              }
            }
            catch ( IOException e ) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          } );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void main( String[] args ) {
    Path directory = Paths.get( ".\\animals" ).toAbsolutePath();
    //deleteContentsOfDirectory( directory );
    try {
      Files.walk( directory );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
