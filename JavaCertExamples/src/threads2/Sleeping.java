package threads2;

public class Sleeping {

  private static int counter = 0;

  public static void main( String[] args ) throws InterruptedException {
    new Thread( () -> {
      for ( int i = 0; i < 50000; i++ )
        Sleeping.counter++;
    } ).start();

    //Bad practice
    /*
    while( Sleeping.counter < 50000 ) {
      System.out.println("Not reached yet");
    }
     */
    
    //Let thread sleep instead
    while( Sleeping.counter < 50000) {
      System.out.println("Not reached yet");
      Thread.sleep( 1000 );
    }

    System.out.println( "Reached!" );

  }

}
