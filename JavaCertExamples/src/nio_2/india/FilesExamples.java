package nio_2.india;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExamples {

  public static void main( String[] args ) throws IOException {
    Path path1 = Paths.get( "Test" );
    Path path2 = Paths.get( "C:\\keith\\JavaCertExamples\\Test" );

    System.out.println( path1 );
    System.out.println( path2 );

    System.out.println( Files.isSameFile( path1, path2 ) );

    if ( Files.exists( path1, LinkOption.NOFOLLOW_LINKS ) ) {
      if ( Files.isDirectory( path1, LinkOption.NOFOLLOW_LINKS ) ) {
        System.out.println( "Is directory" );
      }
      else {
        System.out.println( "Is NOT a directory" );
      }
    }


  }

}
