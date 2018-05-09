package nio;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExists {

  public static void main( String[] args ) {
    System.out.println( Files.exists( Paths.get( "src/nio/" )) );
    System.out.println( Files.exists( Paths.get( "src/nio/FileExists.java" )) );

  }

}
