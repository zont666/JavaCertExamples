package enthuware.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class OpeningFilesOptions {

  public static void main( String[] args ) throws IOException {
    Path writeFile = Paths.get(".\\goat.txt");
    
    BufferedWriter br = Files.newBufferedWriter( writeFile, Charset.forName( "UTF-8" ), //
        new OpenOption[] {StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE}
        );
    
    br.write( "Hello" );
    br.flush();
    br.close();

  }

}
