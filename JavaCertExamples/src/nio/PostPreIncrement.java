package nio;

public class PostPreIncrement {

  public static void main( String[] args ) {
    int num1 = 1;
    int num2 = 1;

    System.out.println("num1 = " + num1++);
    System.out.println("num2 = " + ++num2);
    
    System.out.println("num1 = " + num1);
    System.out.println("num2 = " + num2);

  }

}
