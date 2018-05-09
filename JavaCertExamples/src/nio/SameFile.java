package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SameFile {

  public static void main( String[] args ) throws IOException {
    System.out.println( Files.isSameFile( Paths.get( "." ), Paths.get( "." ) ) );
    
    System.out.println( Files.isSameFile( Paths.get( "src/nio/FileExists.java" ), Paths.get( "src/nio/FileExists.java" ) ) );

  }

}
