package lambdas;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class MethodReferencesTest {

  public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements( SOURCE sourceCollection, Supplier<DEST> collectionFactory ) {
    DEST result = collectionFactory.get();
    for ( T t : sourceCollection ) {
      result.add( t );
    }
    return result;
  }

  public static void main( String[] args ) {
    List<Person> roster = Person.createRoster();

    System.out.println( "Unsorted" );
    for ( Person p : roster ) {
      p.printPerson();
    }

    Person[] rosterAsArray = roster.toArray( new Person[roster.size()] );

    class PersonAgeComparator implements Comparator<Person> {
      @Override
      public int compare( Person o1, Person o2 ) {
        return o1.birthday.compareTo( o2.birthday );
      }
    }

    //Without method reference
    Arrays.sort( rosterAsArray, new PersonAgeComparator() );

    // With lambda expression
    Arrays.sort( rosterAsArray, ( a, b ) -> a.birthday.compareTo( b.birthday ) );

    // With method reference
    Arrays.sort( rosterAsArray, Person::compareByAge );

    // Reference to an instance method of a particular object
    class ComparisonProvider {
      public int compareByName( Person a, Person b ) {
        return a.name.compareTo( b.name );
      }

      public int compareByBirthday( Person a, Person b ) {
        return a.birthday.compareTo( b.birthday );
      }
    }

    ComparisonProvider comparisonProvider = new ComparisonProvider();
    Arrays.sort( rosterAsArray, comparisonProvider::compareByName );

    // Reference to an instance method
    // of an arbitrary object of a particular type
    String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
    Arrays.sort( stringArray, String::compareToIgnoreCase );

    
    Set<Person> rosterSetLambda = transferElements( roster, () -> new HashSet<>() );
    Set<Person> rosterSetMethodRef = transferElements( roster, HashSet::new );
    
    System.out.println( "transferred using lambdas" );
    rosterSetLambda.stream().forEach( Person::printPerson );
    
    System.out.println( "transferred using method reference" );
    rosterSetMethodRef.stream().forEach( Person::printPerson );
  }

}

class Person {
  enum Sex {
    MALE, FEMALE
  }

  String name;
  LocalDate birthday;
  Sex gender;
  String emailAddress;

  Person( String nameArg, LocalDate birthdayArg, Sex genderArg, String emailArg ) {
    name = nameArg;
    birthday = birthdayArg;
    gender = genderArg;
    emailAddress = emailArg;
  }

  int getAge() {
    return birthday //
        .until( IsoChronology.INSTANCE.dateNow() ) //
        .getYears();
  }

  void printPerson() {
    System.out.println( name + ", " + getAge() );
  }

  static int compareByAge( Person a, Person b ) {
    return a.birthday.compareTo( b.birthday );
  }

  static List<Person> createRoster() {
    List<Person> roster = new ArrayList<>();
    roster.add( new Person( "Fred", IsoChronology.INSTANCE.date( 1980, 6, 20 ), Person.Sex.MALE, "fred@example.com" ) );
    roster.add( new Person( "Jane", IsoChronology.INSTANCE.date( 1990, 7, 15 ), Person.Sex.FEMALE, "jane@example.com" ) );
    roster.add( new Person( "George", IsoChronology.INSTANCE.date( 1991, 8, 13 ), Person.Sex.MALE, "george@example.com" ) );
    roster.add( new Person( "Bob", IsoChronology.INSTANCE.date( 2000, 9, 12 ), Person.Sex.MALE, "bob@example.com" ) );
    return roster;
  }

}
