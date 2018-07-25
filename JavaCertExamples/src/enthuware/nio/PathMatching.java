package enthuware.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PathMatching {

  public static void main( String[] args ) throws IOException {
    MyFileChecker fileChecker = new MyFileChecker();
    System.out.println( Paths.get( "." ).toAbsolutePath().normalize()  );
    Files.walkFileTree( Paths.get( "." ), fileChecker );
    System.out.println( fileChecker.getCount() );

  }

  static class MyFileChecker extends SimpleFileVisitor<Path> {
    private final PathMatcher matcher;
    private static int count;

    public MyFileChecker() {
      matcher = FileSystems.getDefault().getPathMatcher( "glob:**.java" );
    }

    void check( Path path ) {
      if ( path != null && matcher.matches( path ) ) {
        System.out.println( path );
        count++;
      }
    }

    public int getCount() {
      return count;
    }

    @Override
    public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
      check( file );
      return FileVisitResult.CONTINUE;
    }

  }

}
