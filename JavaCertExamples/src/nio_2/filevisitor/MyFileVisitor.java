package nio_2.filevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor implements FileVisitor<Path>{
  
  public static void main( String[] args ) throws IOException {
    
    Path path = Paths.get( "C:\\GitRepo" );
    FileVisitor<Path> fileVisitor = new MyFileVisitor();
    Files.walkFileTree( path, fileVisitor );
  }

  @Override
  public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs ) throws IOException {
    System.out.println( "preVisit: " + dir );
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
    System.out.println( "visitFile: " + file );
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed( Path file, IOException exc ) throws IOException {
    System.out.println( "visitFileFailed: " + file );
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult postVisitDirectory( Path dir, IOException exc ) throws IOException {
    System.out.println( "visitFilpostVisitDirectoryeFailed: " + dir );
    return FileVisitResult.CONTINUE;
  }

}
