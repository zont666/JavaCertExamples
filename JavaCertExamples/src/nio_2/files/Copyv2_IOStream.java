package nio_2.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copyv2_IOStream {

  public static void main( String[] args ) {
    try(OutputStream os = new FileOutputStream( "notes.txt" )) {
      Path source = Paths.get( "src/nio_2/files/Copy.java" );
      Files.copy( source, os );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
