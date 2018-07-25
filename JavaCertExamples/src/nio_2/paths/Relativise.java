package nio_2.paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Relativise {

  public static void main( String[] args ) {
    Path dir = Paths.get("code");
    Path file = Paths.get("code/java/IO.java");
    
    System.out.println( file.relativize( dir ) );
    System.out.println( dir.relativize( file ) );
    
    dir = Paths.get( "/code" );
    file = Paths.get( "/java/IO.java" );
    
    System.out.println( file.relativize( dir ) );
    System.out.println( dir.relativize( file ) );
    
    
    Path dirC = Paths.get("C:/code/MyClass.java");
    Path dirD = Paths.get("D:/notes/summary.txt");
   
    System.out.println( dirC.relativize( dirD ) );
    

  }

}
