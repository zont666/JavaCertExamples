package enthuware.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvingSiblings {

  public static void main( String[] args ) throws FileNotFoundException, IOException {
    Path p1 = Paths.get( "C:\\temp\\sample\\test2\\trywithresources\\AutoClosing.java" );
    Path p2 = p1.resolveSibling( "newAutoClosing.java" );
    try (BufferedReader br = new BufferedReader( new FileReader( p1.toFile() ) ); //
        BufferedWriter bw = new BufferedWriter( new FileWriter( p2.toFile() ) )) {
      
      String line = null;
      while( (line = br.readLine()) != null) {
        bw.write( line );
        bw.newLine();
      }
    }

  }

}
