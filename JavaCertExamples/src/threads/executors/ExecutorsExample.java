package threads.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {

  public static void main( String[] args ) {
    new Thread( () -> printMessage() ).start();

    Executors.newSingleThreadExecutor().execute( () -> printMessage() );

    Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate( () -> printMessage(), 0, 1, TimeUnit.SECONDS );

  }

  public static void printMessage() {
    System.out.println( Thread.currentThread().getName() + ": Running in isolated thread" );
  }

}
