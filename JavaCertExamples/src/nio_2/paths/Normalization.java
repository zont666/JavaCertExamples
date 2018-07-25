package nio_2.paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Normalization {

  public static void main( String[] args ) {
    Path relativePath = Paths.get( "..\\8-1.txt" );
    Path absolutePath = relativePath.toAbsolutePath();
    Path normalizedPath = absolutePath.normalize();
    
    System.out.println( "relativePath : " + relativePath );
    System.out.println( "absolutePath : " + absolutePath );
    System.out.println( "normalizedPath : " + normalizedPath );
    
    Path file = Paths.get(".\\8-1.txt");
    Path path = file.toAbsolutePath();
    path = path.normalize();
    System.out.println(path);

    System.out.println( "\n\n\n" );
    
    Path path2 = Paths.get("c:\\OCPJavaSE7\\..\\obj8\\.\\8-1.txt");
    System.out.println(path2.toString()); //line1
    System.out.println(path2.getName(1)); //line2
    System.out.println(path2.getParent()); //line3
    System.out.println(path2.subpath(2,4)); //line4
  }

}
