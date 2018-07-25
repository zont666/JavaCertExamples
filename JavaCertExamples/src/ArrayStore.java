
public class ArrayStore {

  public static void main( String[] args ) {
    Base[] baseArr = new DeriOne[3];
    baseArr[0] = new DeriOne();
    baseArr[2] = new DeriTwo();
    System.out.println(baseArr.length);

  }

}

class Base {}
class DeriOne extends Base {}
class DeriTwo extends Base {}
