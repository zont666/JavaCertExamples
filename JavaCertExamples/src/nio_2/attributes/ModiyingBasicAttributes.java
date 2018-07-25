package nio_2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class ModiyingBasicAttributes {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "TimeZones.txt" );
    BasicFileAttributeView view = Files.getFileAttributeView( path, BasicFileAttributeView.class );
    
    view.setTimes( FileTime.from( Instant.now() ), FileTime.from( Instant.now() ), FileTime.from( Instant.now() ) );
    
    BasicFileAttributes attrs = view.readAttributes();
    System.out.println( attrs.creationTime() );
    System.out.println( attrs.lastAccessTime());
    System.out.println( attrs.lastModifiedTime());
    
    //Map<String, Object> values = Files.readAttributes( path, "*");
    Map<String, Object> values = Files.readAttributes( path, "lastModifiedTime,isDirectory");
    for(String attribute : values.keySet()) {
      System.out.println( attribute + " : " + values.get( attribute ) );
    }
    
    FileTime newTime = FileTime.from( Instant.now().plus( 1, ChronoUnit.DAYS ) );
    Files.setAttribute( path, "lastModifiedTime", newTime );
    System.out.println( Files.readAttributes( path, "lastModifiedTime" ) );

    

  }

}
