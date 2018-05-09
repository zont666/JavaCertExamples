package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Question6 {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get(".//animals");
    
    boolean myBoolean = Files.walk( path )
    .filter( p -> Files.isDirectory( p ) && !path.equals( p ))
    .findFirst()
    .isPresent();
    
    System.out.println( myBoolean );
    

  }

}
