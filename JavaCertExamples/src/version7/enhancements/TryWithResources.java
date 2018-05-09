package version7.enhancements;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class TryWithResources {

  public static void main( String[] args ) throws IOException {
    writeToFileZipFileContents( "C:\\test.zip", "C:\\zipFileOutput.log");

  }

  public static void writeToFileZipFileContents( String zipFileName, String outputFileName ) throws IOException {
    Charset charset = StandardCharsets.US_ASCII;
    Path outputFilePath = Paths.get( outputFileName );

    try (ZipFile zipFile = new ZipFile( zipFileName ); //
        BufferedWriter writer = Files.newBufferedWriter( outputFilePath, charset )) {
      for ( Enumeration entries = zipFile.entries(); entries.hasMoreElements(); ) {
        String newLine = System.getProperty("line.separator");
        ZipEntry zipFileEntry = (ZipEntry)entries.nextElement();
        String file = zipFileEntry.getName();
        writer.write( file + newLine, 0, file.length() );
      }

    }

  }

}
