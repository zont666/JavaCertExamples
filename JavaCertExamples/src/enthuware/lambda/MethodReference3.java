package enthuware.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference3 {

  public static void main( String[] args ) {
    List<Leabhar> books = Arrays.asList(new Leabhar("30 Days", "fiction", "K Larsen"),      
        new Leabhar("Fast Food Nation", "non-fiction", "Eric Schlosser"),       new Leabhar("Wired", "fiction", "D Richards"));      
    books.stream()      
    .filter((Leabhar.BookFilter::isFiction)) //LINE 10   
    .forEach((Leabhar b) -> System.out.println(b+", "));
  }

  static class Leabhar {
    private int id;
    private String title;
    private String genre;
    private String author;
    
    @Override
    public String toString() {
      // TODO Auto-generated method stub
      return id + title + genre + author;
    }

    public Leabhar( String title, String genre, String author ) {
      this.title = title;
      this.genre = genre;
      this.author = author;
    }

    public static class BookFilter {

      public static boolean isFiction( Leabhar b ) {
        return b.genre.equals( "fiction" );
      }
    }
  }

}
