package enthuware.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Relativise {

  public static void main( String[] args ) {
    Path p1 = Paths.get( "c:\\personal\\.\\photos\\..\\readme.txt" );
    Path p2 = Paths.get( "c:\\personal\\index.html" );
    Path p3 = p1.relativize( p2 );
    System.out.println( p3 );
    
    //    ..\..\..\
   

  }

}
