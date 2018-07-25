package enthuware.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor implements FileVisitor<Path> {

  private final PathMatcher matcher = FileSystems.getDefault().getPathMatcher( "glob:**/t*" );

  public static void main( String[] args ) {
    MyFileVisitor fileVisitor = new MyFileVisitor();
    try {
      Files.walkFileTree( Paths.get( "C:\\temp" ), fileVisitor );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs ) throws IOException {
    if ( matcher.matches( dir ) ) {
      return FileVisitResult.CONTINUE;
    }
    else {
      return FileVisitResult.SKIP_SUBTREE;
    }
  }

  @Override
  public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
    System.out.println( "Visited " + file );
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed( Path file, IOException exc ) throws IOException {
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult postVisitDirectory( Path dir, IOException exc ) throws IOException {
    return FileVisitResult.CONTINUE;
  }

}
