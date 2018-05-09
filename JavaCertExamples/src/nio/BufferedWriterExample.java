package nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedWriterExample {

  public static void main( String[] args ) {
    Path gorillaFilePath = Paths.get( ".\\animals\\gorilla.txt" );

    try (BufferedWriter writer = Files.newBufferedWriter( gorillaFilePath, Charset.forName( "UTF-16" ) )) {
      writer.write( "Hello world!" );
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
