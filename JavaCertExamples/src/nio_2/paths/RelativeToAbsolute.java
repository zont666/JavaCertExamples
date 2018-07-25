package nio_2.paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativeToAbsolute {

  public static void main( String[] args ) {
    Path relativePath = Paths.get( "8-1.txt" );
    Path absolutePath = relativePath.toAbsolutePath();
    
    System.out.println( "relativePath : " + relativePath );
    System.out.println( "absolutePath : " + absolutePath );
  }

}
