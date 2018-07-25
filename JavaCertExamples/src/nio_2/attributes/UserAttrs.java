package nio_2.attributes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class UserAttrs {

  public static void main( String[] args ) throws IOException {
    Path path = Paths.get( "CustomAttributes.txt" );
    Files.createFile( path );

    UserDefinedFileAttributeView udfAttrs = Files.getFileAttributeView( path, UserDefinedFileAttributeView.class );

    writeAttribute( udfAttrs, "to-be-deleted", true );
    System.out.println( readAttribute( udfAttrs, "to-be-deleted" ) );

  }

  static void writeAttribute( UserDefinedFileAttributeView view, String attribute, boolean value ) throws IOException {
    view.write( attribute, Charset.defaultCharset().encode( String.valueOf( value ) ) );
  }

  static boolean readAttribute( UserDefinedFileAttributeView view, String attribute ) throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate( view.size( attribute ) );
    view.read( attribute, buffer );
    buffer.flip();

    String value = Charset.defaultCharset().decode( buffer ).toString();
    return value.equalsIgnoreCase( "true" );
  }

}
