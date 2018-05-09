package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyingFiles {

  public static void main( String[] args ) throws IOException {
    Files.createDirectory( Paths.get( "panda" ) );
    Files.copy( Paths.get( "panda" ), Paths.get( "panda-save" ) );
    
    Files.copy( Paths.get( "panda/.classpath" ), Paths.get( "panda-save/.classpath" ) );
    
//    System.out.println(  );
//    
//    Files.createFile( Paths.get( "source-data.txt" ) );
//    
//    try(InputStream is = new FileInputStream("source-data.txt");
//        OutputStream os = new FileOutputStream( "target-data.txt" )) {
//      
//      Files.copy( is, Paths.get( "." ) );
//      
//    }

  }

}
