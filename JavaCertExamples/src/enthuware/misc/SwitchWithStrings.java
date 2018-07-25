package enthuware.misc;

public class SwitchWithStrings {

  public static void main( String[] args ) {
//    String[] args2 = {"A", "b", "a", "e"};
//    final String x = "x";
//    
//    for ( String arg : args2 ) {
//      arg = "d";
//      switch ( arg ) {
//        case "a" :
//          arg = "x";
//          args2 = null;
//          System.out.println( "great!" );
//          break;
//        case x :
//          arg = "x";
//          args2 = null;
//          System.out.println( "great!" );
//          break;
//        default :
//          System.out.println( "unknown" );
//      }
//    }
    
    String[] sa = new String[] {"a", "b", null};
    for(String s : sa) {
      switch(s) {
        case "a" : System.out.println( "Got a" );
      }
    }

  }

}
