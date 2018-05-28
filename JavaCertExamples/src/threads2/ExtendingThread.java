package threads2;

public class ExtendingThread extends Thread {

  public static void main( String[] args ) {
    new ExtendingThread().start();

  }
  
  @Override
  public void run() {
    System.out.println("Printing zoo inventory");
  }

}
