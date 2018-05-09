package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Normalize {

  public static void main( String[] args ) {
    Path path3 = Paths.get("E:\\data");
    Path path4 = Paths.get("E:\\user\\home");
    
    Path relativePath = path3.relativize(path4);
    System.out.println( "relative path from 3 to 4: " + relativePath );
    
    
    System.out.println("3 resolving the relative path from 3 to 4: " + path3.resolve(relativePath));
    
    System.out.println("3 resolving the relative path from 3 to 4 (normalised): " + path3.resolve(relativePath).normalize());
    

  }

}
