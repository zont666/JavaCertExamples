package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreatingDirectories {

  public static void main( String[] args ) throws IOException {
    Files.createDirectory( Paths.get( "giraffe" ) );
    
    Files.createDirectories( Paths.get( "bison/field/pasture/green" ) );
  }

}
