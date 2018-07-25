package enthuware.streams;

public class Book {
  private int id;
  private String title;
  private String genre;
  private String author;
  private double price;

  public Book( String title, String genre, String author ) {
    this.title = title;
    this.genre = genre;
    this.author = author;
  }

  public Book( String title, double price ) {
    this.title = title;
    this.price = price;
  }

  public Book( String title ) {
    this.title = title;
  }

  public final int getId() {
    return id;
  }

  public final void setId( int id ) {
    this.id = id;
  }

  public final String getTitle() {
    return title;
  }

  public final void setTitle( String title ) {
    this.title = title;
  }

  public final String getGenre() {
    return genre;
  }

  public final void setGenre( String genre ) {
    this.genre = genre;
  }

  public final String getAuthor() {
    return author;
  }

  public final void setAuthor( String author ) {
    this.author = author;
  }

  public final double getPrice() {
    return price;
  }

  public final void setPrice( double price ) {
    this.price = price;
  }

}
