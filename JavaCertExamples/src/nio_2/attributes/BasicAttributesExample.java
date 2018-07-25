package nio_2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicAttributesExample {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "TimeZones.txt" );
    BasicFileAttributes attrs = Files.readAttributes( path, BasicFileAttributes.class );
    FileTime fileCreationTime  = attrs.creationTime();
    
    System.out.println( attrs);
    System.out.println( attrs.isDirectory() );
    System.out.println( attrs.isOther() );
    System.out.println( attrs.lastAccessTime());
    System.out.println( attrs.lastModifiedTime());
    System.out.println( attrs.creationTime());
  }

}
