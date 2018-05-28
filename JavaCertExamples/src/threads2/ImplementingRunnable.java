package threads2;

public class ImplementingRunnable implements Runnable{

  public static void main( String[] args ) {
    new Thread((new ImplementingRunnable())).start();
    new Thread((new ImplementingRunnable())).start();
    new Thread((new ImplementingRunnable())).start();
    new Thread((new ImplementingRunnable())).start();
    new Thread((new ImplementingRunnable())).start();
    new Thread((new ImplementingRunnable())).start();

  }

  @Override
  public void run() {
    for(int i=0; i<3; i++)
      System.out.println(Thread.currentThread().getName() + " :: Printing record: "+i);
    
  }

}
