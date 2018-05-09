package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Question1 {

  public static void main( String[] args ) {
    Path path = Paths.get( "/user/.././root", "../kodiacbear.txt" );
    System.out.println( "original path: " + path );

    System.out.println( "normalised then relativised: " + path.normalize().relativize( Paths.get( "/lion" ) ) );
  }

}
