package nio_2.files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Createv2_WithExistsCheck {

  public static void main( String[] args ) {
    String baseDir = "C:\\SystemInfo\\";
    String subDir = "CPU_Memory";
    String fileName = "stats_v4.txt";

    Path filePath = Paths.get( baseDir, subDir, fileName );

    try {
      if(Files.notExists( filePath.getParent() )) {
        Files.createDirectory( filePath.getParent() );
      }
      
      if(!Files.exists( filePath )) {
        Files.createFile( filePath );
      }

      PrintWriter pw = new PrintWriter( new FileWriter( filePath.toFile() ) );
      pw.println( "freeMemory: " + Runtime.getRuntime().freeMemory() );
      pw.println( "totalMemory: " + Runtime.getRuntime().totalMemory() );
      pw.println( "maxMemory: " + Runtime.getRuntime().maxMemory() );
      pw.println( "availableProcessors: " + Runtime.getRuntime().availableProcessors() );
      pw.flush();
      pw.close();
    }
    catch ( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
