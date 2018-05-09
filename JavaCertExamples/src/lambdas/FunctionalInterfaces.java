package lambdas;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {

  public static void main( String ... ags ) {
    //processPersonWithFunction( new ArrayList<Person>(), p -> p.gender == Person.Sex.MALE, p -> p.emailAddress, e -> System.out.println( e ) );
  }

//  public static void processPersonWithFunction( List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block ) {
//    for ( Person p : roster ) {
//      if ( tester.test( p ) ) {
//        String data = mapper.apply( p );
//        block.accept( data );
//      }
//    }
//  }

}

//class Person {
//
//  String name;
//  LocalDate birthDay;
//  Sex gender;
//  String emailAddress;
//
//  enum Sex {
//    MALE, FEMALE;
//  }
//}
