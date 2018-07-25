package nio_2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Map;

public class DosAttributes {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "TimeZones.txt" );
    DosFileAttributes dosAttrs = Files.readAttributes( path, DosFileAttributes.class );

    System.out.println( dosAttrs.isHidden() );
    System.out.println( dosAttrs.isSystem() );
    System.out.println( dosAttrs.isArchive() );
    System.out.println( dosAttrs.isReadOnly() );
    
    
    DosFileAttributeView attrView = Files.getFileAttributeView( path, DosFileAttributeView.class );
    attrView.setArchive( true );
    attrView.setReadOnly( true );
    
    
    Map<String, Object> entries = Files.readAttributes( path, "dos:hidden,readonly,system" );
    for(String key: entries.keySet()) {
      System.out.println( key + " : " + entries.get( key ) );
    }
    
    Files.setAttribute( path, "dos:hidden", false);
    System.out.println("dos:hidden: " + Files.readAttributes( path, "dos:hidden" )  );
  }

}
