package enthuware.threads;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

class BeeperControl {

  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool( 1 );

  public void beepForAnHour() {
    final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate( () -> System.out.println( "beep" ), 10, 10, SECONDS );
    scheduler.schedule( () -> {
      beeperHandle.cancel( true );
      scheduler.shutdown();
    }, 60 * 60, SECONDS );
  }

  public static void main( String args[] ) {
    new BeeperControl().beepForAnHour();
  }
}
