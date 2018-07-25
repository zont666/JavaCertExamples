package enthuware.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierItemProcessor extends Thread {

  CyclicBarrier cb;

  public CyclicBarrierItemProcessor( CyclicBarrier cb ) {
    this.cb = cb;
  }

  @Override
  public void run() {
    System.out.println( "processed" );
    try {
      cb.await();
    }
    catch ( InterruptedException | BrokenBarrierException e ) {
      e.printStackTrace();
    }

  }

  public static void main( String[] args ) throws InterruptedException, BrokenBarrierException {
    Merger m = new Merger();

    CyclicBarrier cb = new CyclicBarrier( 2, m );

    CyclicBarrierItemProcessor cip = new CyclicBarrierItemProcessor( cb );
    cip.start();
    cb.await();

  }

}

class Merger implements Runnable {

  @Override
  public void run() {
    System.out.println( "Value Merged" );

  }

}
