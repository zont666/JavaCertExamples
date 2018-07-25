package nio_2.filevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SimpleFileVisitorExample extends SimpleFileVisitor<Path>{

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "." );
    SimpleFileVisitorExample fileVisitor = new SimpleFileVisitorExample();
    Files.walkFileTree( path, fileVisitor );

  }
  
  @Override
  public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
    System.out.println( "File name: " + file.getFileName());
    return FileVisitResult.CONTINUE;
  }

}
