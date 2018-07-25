package nio_2.files;

import java.io.IOException;
import java.nio.file.*;

public class Copy {

  public static void main( String[] args ) {
    Path source = Paths.get( "C:\\SystemInfo\\CPU_Memory\\stats_v2.txt" );
    Path target = Paths.get( "C:\\SystemInfo\\CPU_Memory\\stats_v5.txt" );

    try {
      Files.copy( source, target, StandardCopyOption.REPLACE_EXISTING );

      for ( String b : Files.readAllLines( target ) ) {
        System.out.println( b );
      }
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
