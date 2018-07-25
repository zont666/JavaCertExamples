package streams.india;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIf {

  public static void main( String[] args ) {
    List<String> greeting = new ArrayList<>();
    greeting.add( "hello" );
    greeting.add( "world" );
    greeting.forEach( System.out::println );
    greeting.removeIf(((Predicate<String>) str -> str.startsWith("h")).negate());
    greeting.forEach( System.out::println );

  }

}
