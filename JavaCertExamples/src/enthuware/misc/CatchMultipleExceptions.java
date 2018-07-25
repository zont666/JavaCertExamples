package enthuware.misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CatchMultipleExceptions {

  public static void main( String[] args ) {
    // TODO Auto-generated method stub

  }

  public static void copy( String records1, String records2 ) {
    try (InputStream is = new FileInputStream( records1 ); OutputStream os = new FileOutputStream( records2 )) {

      byte[] buffer = new byte[1024];
      int bytesRead = 0;

      while ( (bytesRead = is.read( buffer )) != -1 ) {
        os.write( buffer, 0, bytesRead );
        System.out.println();
      }
    }
    catch ( IOException | RuntimeException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
