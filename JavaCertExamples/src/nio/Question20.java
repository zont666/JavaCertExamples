package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Question20 {

  public static void main( String[] args ) {
    Path path = Paths.get( "." ).normalize(); // h1
    int count = 0;
    for ( int i = 0; i < path.getNameCount(); ++i ) {
      count++;
    }
    System.out.println( count );

  }

}
