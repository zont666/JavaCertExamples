package threads2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CollectionsExample {

  public static void main( String[] args ) {
   
     
//    //Map<String, Object> foodData = new HashMap<>();
//    Map<String, Object> foodData = new ConcurrentHashMap<>();
//    foodData.put( "penguin", 1 );
//    foodData.put( "flamingo", 2 );
//
//    for ( String key : foodData.keySet() ) {
//      foodData.remove( key );
//    }
//
//    Queue<Integer> queue = new ConcurrentLinkedQueue<>();
//    queue.offer( 10 );
//    queue.offer( 4 );
//    queue.offer( 5 );
//    queue.offer( 9 );
//
//    System.out.println( queue );
//    System.out.println( queue.poll() );
//    System.out.println( queue );
//    System.out.println( queue.poll() );
//    System.out.println( queue );
//
//    Deque<Integer> deque = new ConcurrentLinkedDeque<>();
//    deque.offer( 10 );
//    deque.push( 4 );
//    deque.offer( 5 );
//    deque.push( 9 );
//    System.out.println( deque + "\n\n\n\n\n" );
//
//    try {
//      BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
//      blockingQueue.offer( 39 );
//      blockingQueue.offer( 3, 4, TimeUnit.SECONDS );
//      System.out.println( blockingQueue.poll() );
//      System.out.println( blockingQueue.poll( 10, TimeUnit.MILLISECONDS ) );
//    }
//    catch ( InterruptedException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    
    List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList( 4, 3, 52 ));
    
    for(Integer item : list) {
      System.out.print( item + " " );
      list.add( 9 );
    }
    
    System.out.println("Size: "+list.size());
    
    List<Integer> list2 = Collections.synchronizedList( new ArrayList<>(Arrays.asList( 4, 3, 52 )) );
    synchronized ( list2 ) {
      for(int data : list2) {
        System.out.print( data + " " );
      }
    }

  }

}
