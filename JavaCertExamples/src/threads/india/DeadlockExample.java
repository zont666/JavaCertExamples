package threads.india;

public class DeadlockExample {

  public static void main( String[] args ) throws InterruptedException {
    Counter counter = new Counter();
    Thread t1 = new Thread( counter );
    Thread t2 = new Thread( counter );
    t1.start();
    t2.start();
    System.out.println( "Waiting for threads to complete execution..." );
    t1.join();
    t2.join();
    System.out.println( "Done" );

  }

}

class Balls {
  static long balls = 0;
}

class Runs {
  static long runs = 0;
}

class Counter implements Runnable {

  @Override
  public void run() {
    incrementalBallAfterRun();
    incrementalRunAfterBall();

  }

  public void incrementalBallAfterRun() {
    synchronized ( Runs.class ) {
      synchronized ( Balls.class ) {
        Runs.runs++;
        Balls.balls++;
      }
    }
  }

  public void incrementalRunAfterBall() {
    synchronized ( Balls.class ) {
      synchronized ( Runs.class ) {
        Balls.balls++;
        Runs.runs++;
      }
    }
  }

}
