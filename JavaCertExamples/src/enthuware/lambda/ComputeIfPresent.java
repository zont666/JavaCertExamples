package enthuware.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ComputeIfPresent {

  public static void main( String[] args ) {
    Map<String, Account> myAccts = new HashMap<>();
    myAccts.put( "111", new Account( "111" ) );
    myAccts.put( "222", new BankAccount( "111", 200.0 ) );

    BiFunction<String, Account, Account> bif = ( id, acc ) -> acc instanceof BankAccount ? new BankAccount( id, 300.0 ) : new Account( id );

    myAccts.computeIfPresent( "222", bif );
    BankAccount ba = (BankAccount)myAccts.get( "222" );
    System.out.println( ba.getBalance() );
  }

  static class Account {
    private String id;

    public Account( String id ) {
      this.id = id;
    }

  }

  static class BankAccount extends Account {
    private double balance;

    public BankAccount( String id, double balance ) {
      super( id );
      this.balance = balance;
    }

    public double getBalance() {
      return balance;
    }
  }

}
