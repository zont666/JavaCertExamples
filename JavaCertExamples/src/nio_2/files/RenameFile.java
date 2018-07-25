package nio_2.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RenameFile {

  public static void main( String[] args ) {
    Path source = Paths.get( "notes.txt" );
    Path target = Paths.get( "newNotes.txt" );
    
    try {
      Files.move( source, source.resolveSibling( "newNotes.txt" ) );
      //Files.move( source, source.resolveSibling( target ) );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }

  }

}
