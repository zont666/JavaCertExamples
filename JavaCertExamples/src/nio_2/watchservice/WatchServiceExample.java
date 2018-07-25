package nio_2.watchservice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchServiceExample {

  public static void main( String[] args ) throws IOException {
    try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
      Path confData = Paths.get( "C:\\Java\\wbt-apache-tomcat-7.0-jdk7\\conf" );

      confData.register( watchService, //
          StandardWatchEventKinds.ENTRY_CREATE, //
          StandardWatchEventKinds.ENTRY_DELETE, //
          StandardWatchEventKinds.ENTRY_MODIFY );

      for ( ;; ) {
        WatchKey key;
        //        try {
        System.out.println( "calling take()" );
        //key = watchService.take();
        key = watchService.poll();
        //key = watchService.poll( 5, TimeUnit.SECONDS );
        System.out.println( "Something happened" );
        //        }
        //        catch ( InterruptedException e ) {
        //          e.printStackTrace();
        //          break;
        //        }
        if ( key != null ) {
          for ( WatchEvent<?> event : key.pollEvents() ) {
            WatchEvent.Kind<?> kind = event.kind();

            if ( kind == StandardWatchEventKinds.OVERFLOW ) {
              System.out.println( "OVERFLOW" );
              continue;
            }

            WatchEvent<Path> watchEvent = (WatchEvent<Path>)event;
            Path path = watchEvent.context();
            System.out.println( "[eventType=" + kind + ", path=" + path.getFileName() + "]" );

            if ( !key.reset() ) {
              break;
            }
          }
        }

      }
    }

  }

}
