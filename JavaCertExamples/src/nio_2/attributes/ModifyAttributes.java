package nio_2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

public class ModifyAttributes {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "TimeZones.txt" );
    System.out.println( Files.getAttribute( path, "creationTime" ) );
    FileTime newTime = FileTime.from( Instant.now() );
    Files.setAttribute( path, "creationTime", newTime );
    System.out.println( Files.getAttribute( path, "creationTime" ) );
  }

}
