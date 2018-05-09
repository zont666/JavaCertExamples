package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Move {

  public static void main( String[] args ) throws IOException {
    Files.move( Paths.get( "C:\\zoo"), Paths.get("C:\\zoo-new" ) );
    
//    Files.move(Paths.get("c:\\user\\addresses.txt"),
//        Paths.get("c:\\zoo-new\\addresses2.txt"));

  }

}
