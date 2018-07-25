package enthuware.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvingAndRelativising {

  public static void main( String[] args ) {
    Path p1 = Paths.get( "\\photos\\vacation" );
    Path p2 = Paths.get( "\\yellowstone" );

    System.out.println( "p1.resolve( p2 ): " + p1.resolve( p2 ) );
    System.out.println( "p2.resolve( p1 ): " + p2.resolve( p1 ) );
    System.out.println( "p1.relativize( p2 ): " + p1.relativize( p2 ) );
    System.out.println( "p2.relativize( p1 ): " + p2.relativize( p1 ) );

  }

}
