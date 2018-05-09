package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileAttributeViews {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "animals\\gorilla.txt" );
    BasicFileAttributes fileData = Files.readAttributes( path, BasicFileAttributes.class );

    System.out.println( fileData.isSymbolicLink() );
    System.out.println( fileData.isDirectory() );
    System.out.println( fileData.size() );
    System.out.println( fileData.isOther() );
    System.out.println( fileData.isRegularFile() );
    System.out.println( fileData.creationTime() );
    System.out.println( fileData.lastAccessTime() );
    System.out.println( fileData.lastModifiedTime() );
    System.out.println( fileData.fileKey() );

    BasicFileAttributeView view = Files.getFileAttributeView( path, BasicFileAttributeView.class );
    BasicFileAttributes data = view.readAttributes();

    FileTime lastModifiedTime = FileTime.fromMillis( data.lastAccessTime().toMillis() + 10_000_000 );
    System.out.println( lastModifiedTime );
    view.setTimes( lastModifiedTime, null, null );
    System.out.println( data.lastAccessTime() );
  }

}
