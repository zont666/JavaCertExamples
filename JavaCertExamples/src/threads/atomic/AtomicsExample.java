package threads.atomic;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicsExample {

  private AtomicInteger value = new AtomicInteger( 0 );

  public int increment() {
    return value.incrementAndGet();
  }

  public int decrement() {
    return value.decrementAndGet();
  }

  public int value() {
    return value.get();
  }

  public static void main( String[] args ) {
    AtomicsExample atomicValue = new AtomicsExample();

    ExecutorService exService = Executors.newFixedThreadPool( 50000 );

    for ( ;; ) {
      exService.submit( () -> {
        String threadName = Thread.currentThread().getName();
        //Random random = new Random();
        ThreadLocalRandom.current().nextInt();

        //        try {
        //          Thread.sleep( random.nextInt( 1000 ) );
        //        }
        //        catch ( InterruptedException e ) {
        //          e.printStackTrace();
        //        }

        //System.out.println( threadName + " - value: " + atomicValue.value() );

        if ( ThreadLocalRandom.current().nextInt() % 2 == 0 ) {
          System.out.println( threadName + " - increment: " + atomicValue.increment() );
        }
        else {
          System.out.println( threadName + " - decrement: " + atomicValue.decrement() );
        }

      } );
    }

  }

}
