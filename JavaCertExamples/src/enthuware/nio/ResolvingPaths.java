package enthuware.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvingPaths {

  public static void main( String[] args ) {
    Path p1 = Paths.get( "\\temp\\records" );

    System.out.println( p1.resolve( "clients.dat" ) );
    System.out.println( p1.relativize( Paths.get( "\\clients.dat" ) ) );

  }

}
