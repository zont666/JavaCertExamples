package nio_2.india;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyingMovingDeleting {

  public static void main( String[] args ) throws IOException {
    Path filePath = Paths.get( ".\\Test" );
    Path copyPath = Paths.get( ".\\Test.backup" );

    if ( Files.notExists( copyPath ) ) {
      Files.copy( filePath, copyPath );
    }

    Path movePath = Paths.get( ".\\Test.backup_new" );
    if ( Files.notExists( movePath ) ) {
      Files.move( copyPath, movePath );
    }
    
    Files.delete( movePath );

  }

}
