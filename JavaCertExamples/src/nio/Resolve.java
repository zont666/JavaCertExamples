package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Resolve {

  public static void main( String[] args ) {
    final Path path1 = Paths.get("/cats/../panther");
    final Path path2 = Paths.get("food");
    System.out.println(path1.resolve(path2));
  }

}
