package enthuware.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;

public class FileAttributes {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get("c:\\temp\\test.txt");
    
    PosixFileAttributeView posixView = Files.getFileAttributeView( path, PosixFileAttributeView.class );
    PosixFileAttributes attrs = posixView.readAttributes();
    String ownername = attrs.owner().getName();

  }

}
