package threads3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Question9 extends RecursiveTask<Integer> {

  private Integer[] elements;
  private int a;
  private int b;

  public Question9( Integer[] elements, int a, int b ) {
    this.elements = elements;
    this.a = a;
    this.b = b;
  }

  public static void main( String[] args ) {
    Integer[] elements = new Integer[] { 8, -3, 2, -54, -456, 159, 357, -789, 1000 };
    Question9 task = new Question9( elements, 0, elements.length-1 );
    ForkJoinPool pool = new ForkJoinPool();
    Integer sum = pool.invoke( task );
    System.out.println("Min: " + sum);
  }

  @Override
  protected Integer compute() {
    System.out.println( Thread.currentThread().getName() );
    if ( (b - a) < 2 ) {
      return Math.min(elements[a], elements[b]);
    }
    else {
      int m = a + ((b - a) / 2);
      System.out.println( a + "," + m + "," + b );
      Question9 newTask = new Question9( elements, a, m );
      newTask.fork();
      return Math.min( new Question9( elements, m, b ).compute(), newTask.join() );
    }
  }

}
