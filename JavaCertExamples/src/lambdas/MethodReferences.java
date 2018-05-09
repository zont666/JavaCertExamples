package lambdas;

import java.time.LocalDate;
import java.util.Arrays;

public class MethodReferences {

  public static void main( String[] args ) {
    Human seniorCitizen = new Human( "Mary", Human.Sex.FEMALE, LocalDate.of( 1937, 5, 22 ), null );
    Human teenager = new Human( "Jane", Human.Sex.FEMALE, LocalDate.of( 2004, 4, 4 ), null );
    Human child = new Human( "Bradley", Human.Sex.MALE, LocalDate.of( 2011, 11, 22 ), null );
    Human infant = new Human( "Louie", Human.Sex.MALE, LocalDate.of( 2018, 3, 6 ), null );

    System.out.format( "%s is %s years old%n", seniorCitizen.name, seniorCitizen.getAge() );
    System.out.format( "%s is %s years old%n", teenager.name, teenager.getAge() );
    System.out.format( "%s is %s years old%n", child.name, child.getAge() );
    System.out.format( "%s is %s years old%n", infant.name, infant.getAge() );

    Human[] rosterArray = { seniorCitizen, infant, child, teenager };
    Arrays.sort( rosterArray, Human::compareByAge );

  }

}

class Human {

  public Human( String name, Sex gender, LocalDate birthday, String emailAddress ) {
    this.name = name;
    this.gender = gender;
    this.birthday = birthday;
    this.emailAddress = emailAddress;
  }

  enum Sex {
    MALE, FEMALE
  }

  String name;
  LocalDate birthday;
  Sex gender;
  String emailAddress;

  public int getAge() {
    return birthday.until( LocalDate.now() ).getYears();
  }

  public static int compareByAge( Human p1, Human p2 ) {
    return p1.birthday.compareTo( p2.birthday );
  }
}
