package enthuware.nio;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class ListingRootDirectories {

  public static void main( String[] args ) {
    FileSystem fileSystem = FileSystems.getDefault();
    for(Path path : fileSystem.getRootDirectories()) {
      System.out.println( path );
    }

  }

}
