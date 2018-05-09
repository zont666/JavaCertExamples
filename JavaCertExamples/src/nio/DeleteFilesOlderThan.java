package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class DeleteFilesOlderThan {

  public static void main( String[] args ) {
    LocalDate ninetyDaysAgo = LocalDate.now().minusDays( 90 );
    System.out.println( "ninetyDaysAgo: " + ninetyDaysAgo );

    Path filePath = Paths.get( "C:\\dummyFiles\\sub\\sub2" );
    try {
      Files.list( filePath ) //
          .filter( file -> Files.isRegularFile( file ) ) //
          .forEach( file -> {
            try {
              FileTime lastModifiedTime = Files.getLastModifiedTime( file );
              LocalDate lastModifiedDate = LocalDate.ofEpochDay( lastModifiedTime.to( TimeUnit.DAYS ) );

              if ( lastModifiedDate.compareTo( ninetyDaysAgo ) < 0 ) {
                Files.delete( file );
              }
              else {
                System.out.println( file + " should be KEPT, date: " + lastModifiedDate );
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

}
