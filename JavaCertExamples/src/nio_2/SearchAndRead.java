package nio_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;

public class SearchAndRead {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "./TimeZones.txt" );
    
    Files.find( path.getParent(), 10, 
        (Path p, BasicFileAttributes b) -> p.toString().endsWith( ".txt" ) && Files.isRegularFile( p ) ) //
    .collect( Collectors.toList() )
    .forEach( System.out::println );
    
   

  }

}
