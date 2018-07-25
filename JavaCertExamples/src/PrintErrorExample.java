import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintErrorExample {
  public static void main( String[] args ) throws FileNotFoundException {
    OutputStream os = new FileOutputStream( "lo56565g.txt" );
    System.setErr( new PrintStream( os ) );
    System.err.println( "ERROR" );
  }
}
