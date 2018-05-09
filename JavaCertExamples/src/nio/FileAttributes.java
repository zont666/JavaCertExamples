package nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class FileAttributes {

  public static void main( String[] args ) throws IOException {
    System.out.println( Files.isDirectory( Paths.get( "animals" ) ) );

    System.out.println( Files.isRegularFile( Paths.get( "animals\\.classpath" ) ) );

    System.out.println( Files.isSymbolicLink( Paths.get( "animals" ) ) );

    System.out.println( Files.isHidden( Paths.get( "animals\\.classpath" ) ) );

    System.out.println( Files.isReadable( Paths.get( "animals\\.classpath" ) ) );

    System.out.println( Files.isExecutable( Paths.get( "animals" ) ) );

    System.out.println( Files.size( Paths.get( "animals\\.classpath" ) ) );

    System.out.println( Files.getLastModifiedTime( Paths.get( "animals\\.classpath" ) ) );

    Files.setLastModifiedTime( Paths.get( "animals\\.classpath" ), FileTime.fromMillis( System.currentTimeMillis() ) );

    System.out.println( Files.getLastModifiedTime( Paths.get( "animals\\.classpath" ) ) );
    
    /////////////////////
    
    UserPrincipal fileOwner = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName( "kcarroll" );
    
    Files.setOwner( Paths.get( "animals\\.classpath" ), fileOwner );
    
    System.out.println( Files.getOwner( Paths.get( "animals\\.classpath" )).getName() );

  }

}
