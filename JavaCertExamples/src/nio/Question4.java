package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Question4 {

  public static void main( String[] args ) {
    Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
    System.out.println("ANSWER: " + path.subpath(1,3).getName(1).toAbsolutePath());

  }

}
