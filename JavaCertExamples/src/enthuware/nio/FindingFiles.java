package enthuware.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FindingFiles {

  public static void main( String[] args ) {
    try {
      Stream<Path> s = Files.find( Paths.get("c:\\temp\\pathtest"), Integer.MAX_VALUE , (path, attrs) -> path.endsWith( "test.txt" ) && attrs.isRegularFile() );
      s.forEach( p -> {
        try {
          Stream<String> x = Files.lines( p );
          x.forEach( System.out::println );
        }
        catch ( IOException e ) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      });
    }
    catch ( IOException ioe ) {
      ioe.printStackTrace();
    }

  }

}
