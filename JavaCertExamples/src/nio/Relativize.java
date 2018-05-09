package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Relativize {

  public static void main( String[] args ) {
    Path birdPath = Paths.get( "bird.txt" );
    Path fishPath = Paths.get( "fish.txt" );

    System.out.println( birdPath.relativize( fishPath ) );
    System.out.println( fishPath.relativize( birdPath ) );

    System.out.println();

    Path path3 = Paths.get( "E:\\habitat" );
    Path path4 = Paths.get( "E:\\sanctuary\\raven" );
    System.out.println( path3.relativize( path4 ) );
    System.out.println( path4.relativize( path3 ) );
  }

}
