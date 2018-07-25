package nio_2.india;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Streams {

  public static void main( String[] args ) throws IOException {
    try(Stream<Path> entries = Files.list( Paths.get( "." ) )){
      entries
      .map( path -> path.toAbsolutePath().normalize() )
      .forEach( System.out::println );
    }
    
    
    try(Stream<Path> entries = Files.walk( Paths.get( "." ), FileVisitOption.FOLLOW_LINKS )){
      //long numberOfEntries = entries.count();
      //System.out.printf( "Found %d entries in the current path", numberOfEntries );
      entries
      .map( path -> path.toAbsolutePath().normalize() )
      .forEach( System.out::println );
    }
    
    BiPredicate<Path, BasicFileAttributes> predicate = (path, attrs) -> attrs.isRegularFile() && path.toString().endsWith( "java" );
    try(Stream<Path> entries = Files.find( Paths.get( "." ), 10, predicate )){
      entries.forEach( path -> {
        try(Stream<String> lines = Files.lines( path )){
          lines.forEach( System.out::println );
        }
        catch ( IOException e ) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      });
    }
    
    
    
    

  }

}
