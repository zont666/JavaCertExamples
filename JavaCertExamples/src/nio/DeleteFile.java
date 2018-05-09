package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteFile {

  public static void main( String[] args ) {
    try {
      Files.delete( Paths.get( "C:\\vulture\\feathers.txt" ) );
    }
    catch ( IOException e ) {
      System.out.println( "Files.delete() -> File to delete not found" );
    }
    
    try {
      Files.deleteIfExists( Paths.get( "C:\\vulture\\feathers.txt" ) );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      System.out.println( " Files.deleteIfExists() -> File to delete not found" );
    }

  }

}
