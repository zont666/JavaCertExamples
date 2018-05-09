package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Question11 {

  public static void main( String[] args ) throws IOException {
    Path path1 = Paths.get("./goat.txt").normalize(); // k1
    Path path2 = Paths.get("mule.png");
    Files.copy(path1,path2,StandardCopyOption.COPY_ATTRIBUTES); //k2
    System.out.println(Files.isSameFile(path1, path2)); //k3
  }

}
