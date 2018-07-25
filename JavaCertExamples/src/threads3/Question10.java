package threads3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class Question10 extends RecursiveAction {
  private int start;
  private int end;

  public Question10( int start, int end ) {
    this.start = start;
    this.end = end;
  }

  public static void main( String[] args ) {
    ForkJoinTask<?> task = new Question10(0, 4); // m2
    ForkJoinPool pool = new ForkJoinPool();
    Object result = pool.invoke(task); // m3
  }

  @Override
  protected void compute() {
    if(start > 0 ) {
       return;
    }else {
      int middle = start + ((end - start)/2);
      invokeAll( new Question10( start, middle ), new Question10( middle, end ) );
    }

  }

}
