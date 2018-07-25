package enthuware.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class MyWatchService {

  public static void main( String[] args ) throws InterruptedException, IOException {
    Path path = Paths.get( "C:/temp" );

    WatchService watchService = FileSystems.getDefault().newWatchService();
    path.register( watchService, StandardWatchEventKinds.ENTRY_CREATE, //
        StandardWatchEventKinds.ENTRY_DELETE, //
        StandardWatchEventKinds.ENTRY_MODIFY );
    
    for ( ;; ) {
      WatchKey key = watchService.take();
      System.out.println( key.isValid() );
      
      for ( WatchEvent<?> event : key.pollEvents() ) {
        Kind<?> kind = event.kind();
        System.out.println( event.count() );
        System.out.println( event.context() );
        System.out.println( "kind.name() " + kind.name() );
        System.out.println( "kind.type() " + kind.type() );
      }
      
      key.reset();
    }

  }

}
