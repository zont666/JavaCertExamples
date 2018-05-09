package version7.enhancements.interfaces.cards;

public class PlayingCard implements Card {

  private Card.Rank rank;
  private Card.Suit suit;

  public PlayingCard( Card.Rank rank, Card.Suit suit ) {
    this.rank = rank;
    this.suit = suit;
  }

  @Override
  public int compareTo( Card card ) {
    return this.hashCode() - card.hashCode();
  }

  @Override
  public Suit getSuit() {
    return suit;
  }

  @Override
  public Rank getRank() {
    return rank;
  }

  @Override
  public int hashCode() {
    return ((suit.value() - 1) * 13) + rank.value();
  }

  @Override
  public boolean equals( Object obj ) {
    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass() )
      return false;
    PlayingCard other = (PlayingCard)obj;
    if ( rank != other.rank )
      return false;
    if ( suit != other.suit )
      return false;
    return true;
  }

  @Override
  public String toString() {
    return rank.text() + " of " + suit.text();
  }

}
