package enthuware.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultWithoutBlockingExample {

  public static void main( String[] args ) throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newFixedThreadPool( 2 );
    MyTask task = new MyTask();
    Future<String> result = executor.submit( task );
    System.out.println( "Proceeding without blocking... " );
    while ( !result.isDone() ) {
      System.out.println( "result not ready yet..." );
      Thread.sleep( 50 );
    }
    System.out.println( "Result is " + result.get() );
    executor.shutdown();

  }

  static class MyTask implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
      Thread.sleep( 2000 );
      return "Data from " + Thread.currentThread().getName();
    }

  }

}
