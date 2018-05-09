package version7.enhancements.interfaces.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StandardDeck implements Deck {

  private List<Card> deckOfCards;

  public StandardDeck() {
    this.deckOfCards = new ArrayList<>();

    for ( Card.Suit suit : Card.Suit.values() ) {
      for ( Card.Rank rank : Card.Rank.values() ) {
        deckOfCards.add( new PlayingCard( rank, suit ) );
      }
    }
  }

  public StandardDeck( List<Card> existingList ) {
    this.deckOfCards = existingList;
  }

  @Override
  public List<Card> getCards() {
    return deckOfCards;
  }

  @Override
  public Deck deckFactory() {
    return new StandardDeck( new ArrayList<Card>() );
  }

  @Override
  public int size() {
    return deckOfCards.size();
  }

  @Override
  public void addCard( Card card ) {
    deckOfCards.add( card );

  }

  @Override
  public void addCards( List<Card> cards ) {
    deckOfCards.addAll( cards );

  }

  @Override
  public void addDeck( Deck deck ) {
    deckOfCards.addAll( deck.getCards() );
  }

  @Override
  public void shuffle() {
    Collections.shuffle( deckOfCards );
  }

  @Override
  public void sort() {
    Collections.sort( deckOfCards );
  }

  @Override
  public void sort( Comparator<Card> c ) {
    Collections.sort( deckOfCards, c );
  }

  @Override
  public String deckToString() {
    return deckOfCards.stream() //
        .map( Card::toString ) //
        .collect( Collectors.joining( "\n" ) );
  }

  @Override
  public Map<Integer, Deck> deal( int players, int numberOfCards ) throws IllegalArgumentException {
    int cardsDealt = players * numberOfCards;
    int sizeOfDeck = deckOfCards.size();
    if ( cardsDealt > sizeOfDeck ) {
      throw new IllegalArgumentException( //
          "Number of players (" + players + //
              ") times number of cards to be dealt (" + numberOfCards + //
              ") is greater than the number of cards in the deck (" + //
              sizeOfDeck + ")." );
    }

    Map<Integer, List<Card>> dealtDeck = deckOfCards.stream() //
        .collect( Collectors.groupingBy( card -> {
          int cardIndex = deckOfCards.indexOf( card );
          if ( cardIndex >= cardsDealt ) {
            return players + 1;
          }
          else {
            return (cardIndex % players) + 1;
          }
        }

    ) );

    Map<Integer, Deck> mapToReturn = new HashMap<>();

    for ( int i = 1; i <= (players + 1); i++ ) {
      Deck currentDeck = deckFactory();
      currentDeck.addCards( dealtDeck.get( i ) );
      mapToReturn.put( i, currentDeck );
    }

    return mapToReturn;
  }

  public static void main( String[] args ) {
    System.out.println( "................. Creating deck" );
    StandardDeck deck = new StandardDeck();
    deck.sort();
    System.out.println( "................. Sorted deck" );
    System.out.println( deck.deckToString() );
    deck.shuffle();
    System.out.println( "................. Shuffled deck" );
    System.out.println( deck.deckToString() );

    deck.sort( //
        Comparator.comparing( Card::getRank ) //
            .thenComparing( Card::getSuit ) );

    System.out.println( "................. Sorted by rank, then by suit " );
    System.out.println( deck.deckToString() );

    deck.sort( //
        Comparator.comparing( Card::getRank ) //
            .reversed() //
            .thenComparing( Card::getSuit ) //
    );
    
    System.out.println( "................. Sorted by rank reversed, then by suit " );
    System.out.println( deck.deckToString() );
    
    System.out.println( "\n\n\n\n\n" );
    deck.shuffle();
    deck.deal( 5, 2 );

  }

}
