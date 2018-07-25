package nio_2.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Delete {

  public static void main( String[] args ) {
    Path path = Paths.get( "newNotes" );
    try {
      Files.createDirectory( path);
    }
    catch ( IOException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    try {
      Files.delete( path );
      System.out.println( "File deleted succesfully" );
    }
    catch ( IOException e ) {
      System.err.println( "Could not find file" );
    }

    boolean fileDeleted;
    try {
      fileDeleted = Files.deleteIfExists( path );
      System.out.println( "File deleted: " + fileDeleted );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
