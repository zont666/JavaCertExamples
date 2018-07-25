package threads.india;

public class CannotFlyException extends Exception {

}

interface Birdie {
  public abstract void fly() throws CannotFlyException;
}

interface Biped {
  public void walk();
}

abstract class NonFlyer {
  public void fly() {
    System.out.print( "cannot fly " );
  }
}

class Penguin  extends NonFlyer implements Birdie, Biped { // LINE B
  public void walk() {
    System.out.print( "walk " );
  }
}
