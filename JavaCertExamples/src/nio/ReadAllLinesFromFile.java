package nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadAllLinesFromFile {

  public static void main( String[] args ) throws IOException {
    Path gorillaFilePath = Paths.get( ".\\animals\\.classpath" );
    List<String> lines = Files.readAllLines( gorillaFilePath );

//    for ( String line : lines ) {
//      System.out.println(line);
//    }

    lines.stream() //
        .forEach( System.out::println );

  }

}
