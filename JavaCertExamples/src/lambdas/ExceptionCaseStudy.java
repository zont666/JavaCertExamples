package lambdas;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class ExceptionCaseStudy {
  
  private static List<String> create() throws IOException{
    throw new IOException();
  }
  
  private static List<String> createSafe(){
    try {
      return create();
    }catch(IOException e) {
      throw new RuntimeException();
    }
    
  }

  public static void main( String[] args ) throws IOException {
    ExceptionCaseStudy.create().stream().count();
    
    //Does not compile - Supplier interface does not allow checked exceptions
    //Supplier<List<String>> s = ExceptionCaseStudy::create;

    Supplier<List<String>> s = ExceptionCaseStudy::createSafe;
  }

}
