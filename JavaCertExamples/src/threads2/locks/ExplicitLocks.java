package threads2.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLocks {
  public static void main( String[] args ) {
    Inventory location1 = new Inventory( "Seattle" );
    location1.inStock = 100;

    Inventory location2 = new Inventory( "LA" );
    location2.inStock = 200;

    Shipment s1 = new Shipment( location1, location2, 1 );
    Shipment s2 = new Shipment( location2, location1, 10 );
    Shipment s3 = new Shipment( location1, location2, 10 );
    Shipment s4 = new Shipment( location2, location1, 100 );
    Shipment s5 = new Shipment( location1, location2, 100 );
    Shipment s6 = new Shipment( location2, location1, 1000 );
    Shipment s7 = new Shipment( location1, location2, 10000 );
    Shipment s8 = new Shipment( location2, location1, 100000 );
    Shipment s9 = new Shipment( location1, location2, 1000000 );
    Shipment s10 = new Shipment( location2, location1, 10000000 );

    s1.start();
    s2.start();
    s3.start();
    s4.start();
    s5.start();
    s6.start();
    s7.start();
    s8.start();
    s9.start();
    s10.start();
  }
}

class Inventory {

  int inStock;
  String name;
  Lock lock = new ReentrantLock();

  Inventory( String name ) {
    this.name = name;
  }

  public void stockIn( long qty ) {
    inStock += qty;
  }

  public void stockOut( long qty ) {
    inStock -= qty;
  }

}

class Shipment extends Thread {
  Inventory location1, location2;
  int qty;

  Shipment( Inventory location1, Inventory location2, int qty ) {
    this.location1 = location1;
    this.location2 = location2;
    this.qty = qty;
  }

  @Override
  public void run() {
    if ( location1.lock.tryLock() ) {
      if ( location2.lock.tryLock() ) {
        location2.stockOut( qty );
        location1.stockIn( qty );
        System.out.println( location1.inStock + ":" + location2.inStock );
        location1.lock.unlock();
        location2.lock.unlock();
      }
      else {
        System.out.println( "Locking 1 false:" + location2.name );
      }
    }
    else {
      System.out.println( "Locking 2 false:" + location1.name );
    }

  }
}
