package threads;

public class DeadlockExample {

  static class Friend {
    private final String name;

    public Friend( String name ) {
      this.name = name;
    }

    public String getName() {
      return this.name;
    }

    public synchronized void bow( Friend bowee ) {
      System.out.format( "%s: bowed to %s%n", this.name, bowee.getName() );
      bowee.bowBack( this );
    }

    public synchronized void bowBack( Friend bowee ) {
      System.out.format( "%s: bowed back to %s%n", this.name, bowee.getName() );
    }
  }

  public static void main( String[] args ) {
    final Friend alphonse = new Friend( "Alphonse" );
    final Friend gaston = new Friend( "Gaston" );

    new Thread( new Runnable() {
      @Override
      public void run() {
        alphonse.bow( gaston );
      }
    } ).start();

    new Thread( new Runnable() {
      @Override
      public void run() {
        gaston.bow( alphonse );
      }
    } ).start();
  }

}
