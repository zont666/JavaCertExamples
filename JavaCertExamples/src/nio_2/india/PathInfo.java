package nio_2.india;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo {

  public static void main( String[] args ) {
    Path testFilePath = Paths.get( ".\\Test" );

    System.out.println( testFilePath.getFileName() );
    System.out.println( testFilePath.toUri() );
    System.out.println( testFilePath.toAbsolutePath() );
    System.out.println( testFilePath.normalize() );
    System.out.println( testFilePath.getFileSystem() );

    Path dirName = Paths.get( "D:\\OCPJP\\programs\\NIO2\\" );
    Path resolvedPath = dirName.resolve( "Test" );
    System.out.println( resolvedPath );

    Path path1 = Paths.get( "Test" );
    Path path2 = Paths.get( "C:\\keith\\JavaCertExamples\\Test" );
    
    System.out.println( path1 );
    System.out.println( path2 );

    // comparing two paths using compareTo() method
    System.out.println( "(path1.compareTo(path2) == 0) is: " + (path1.compareTo( path2 ) == 0) );
    // comparing two paths using equals() method
    System.out.println( "path1.equals(path2) is: " + path1.equals( path2 ) );
    // comparing two paths using equals() method with absolute path
    System.out.println( "path2.equals(path1.toAbsolutePath()) is " + path2.equals( path1.toAbsolutePath() ) );

  }

}
