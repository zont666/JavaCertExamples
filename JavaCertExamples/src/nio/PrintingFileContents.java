package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintingFileContents {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( ".\\animals\\sample.log" );
    
    try {
      Files.lines( path ) //
      .filter( s -> s.startsWith( "WARN" ) ) //
      .map( s -> s.substring( 5 ) ) //
      .forEach( System.out::println );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
