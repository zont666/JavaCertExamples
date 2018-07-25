package nio_2.india;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributes {

  public static void main( String[] args ) throws IOException {
    Path javaClassFilePath = Paths.get( "src\\nio_2\\india\\FilesExamples.java" );
    System.out.printf( "Readable %b, Writeable %b, Executable %b %n%n%n%n", Files.isReadable( javaClassFilePath ), Files.isWritable( javaClassFilePath ), Files.isExecutable( javaClassFilePath ) );

    
    Object object = Files.getAttribute( javaClassFilePath, "creationTime", LinkOption.NOFOLLOW_LINKS );
    System.out.println( "creationTime " + object );
    
    object = Files.getAttribute( javaClassFilePath, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS );
    System.out.println( "lastModifiedTime " + object );
    
    object = Files.getAttribute( javaClassFilePath, "size", LinkOption.NOFOLLOW_LINKS );
    System.out.println( "size " + object );
    
    object = Files.getAttribute( javaClassFilePath, "dos:hidden", LinkOption.NOFOLLOW_LINKS );
    System.out.println( "dos:hidden " + object );
    
    object = Files.getAttribute( javaClassFilePath, "isDirectory", LinkOption.NOFOLLOW_LINKS );
    System.out.println( "isDirectory " + object );
    
    
    BasicFileAttributes fileAttrs = Files.readAttributes( javaClassFilePath, BasicFileAttributes.class );
    System.out.println( fileAttrs.isSymbolicLink() );
    System.out.println( fileAttrs.isDirectory() );
    System.out.println( fileAttrs.isRegularFile());
    System.out.println( fileAttrs.isOther() );
    System.out.println( fileAttrs.lastAccessTime() );

  }

}
