package threads2.locks;

import java.util.concurrent.locks.ReentrantLock;

public class NonBlockStructuredLocking {
  public static void main( String[] args ) {
    Train train = new Train();
    
    Passenger e1 = new Passenger( "Paul", train );
    Passenger e2 = new Passenger( "John", train );
    Passenger e3 = new Passenger( "John1", train );
    Passenger e4 = new Passenger( "John2", train );
    Passenger e5 = new Passenger( "John3", train );
    Passenger e6 = new Passenger( "John4", train );
    
    e1.start();
    e2.start();
    e3.start();
    e4.start();
    e5.start();
    e6.start();
    
  }
}

class Train {
  ReentrantLock lock = new ReentrantLock();
  //boolean locked = false;

  public void boardTrain( String name ) {
    if ( lock.tryLock() ) {
      //locked = true;
      System.out.println( name + " :  boarded" );
    }else {
      System.err.println( name + " :  couldn't acquire lock" );
    }
  }

  public void alightTrain( String name ) {
    if ( lock.isHeldByCurrentThread() ) {
      System.out.println( name + " :  alighted" );
      lock.unlock();
    }else {
      System.err.println( name + " :  does not currently hold lock" );
    }
  }

}

class Passenger extends Thread {
  Train train;
  String name;

  Passenger( String name, Train train ) {
    this.train = train;
    this.name = name;
  }

  @Override
  public void run() {
    train.boardTrain( name );
    train.alightTrain( name );
  }
}
