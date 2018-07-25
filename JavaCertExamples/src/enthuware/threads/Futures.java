package enthuware.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures implements Callable<String> {

  public static void main( String[] args ) throws InterruptedException, ExecutionException {
    ExecutorService es =  Executors.newSingleThreadExecutor();
    Future<String> future = es.submit( new Futures() );
    System.out.println( future.get() );
    es.shutdownNow();
  }

  @Override
  public String call() throws Exception {
    Thread.sleep( 5000 );
    return "DONE";
  }

}
