package nio_2.india;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathIterator {

  public static void main( String[] args ) {
    Path aFilePath = Paths.get("D:\\directory\\file.txt");
     
    Iterator<Path> iterator = aFilePath.iterator();
    while(iterator.hasNext()) {
      System.out.println( iterator.next() );
    } 

  }

}
