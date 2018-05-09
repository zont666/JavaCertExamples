package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderExample {

  public static void main( String[] args ) {
    System.out.println( Charset.defaultCharset() );

    //Create file inside directory
    try {
      Files.createDirectories( Paths.get( ".\\animals\\" ) );
      Files.createFile( Paths.get( ".\\\\animals\\\\gorilla.txt" ) );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      System.err.println( "could not create animals\\gorilla.txt" );
    }

    //Copy contents of file into target file
    Path gorillaPath = Paths.get( ".\\\\animals\\\\gorilla.txt" );

    try (BufferedReader reader = Files.newBufferedReader( gorillaPath, Charset.forName( "US-ASCII" ) )) {
      String currentLine = null;
      while ( (currentLine = reader.readLine()) != null ) {
        System.out.println( "Line: " + currentLine );
      }
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
