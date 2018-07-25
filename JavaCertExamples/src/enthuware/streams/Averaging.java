package enthuware.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Averaging {

  public static void main( String[] args ) {
    List<Item> items = Arrays.asList( //
        new Item( "Pen", "Stationery", 3.0 ), //
        new Item( "Pencil", "Stationery", 2.0 ), //
        new Item( "Eraser", "Stationery", 1.0 ), //
        new Item( "Milk", "Food", 2.0 ), //
        new Item( "Eggs", "Food", 3.0 ) //
    );

    ToDoubleFunction<Item> priceFunc = Item::getPrice;

    items.stream() //
        .collect( Collectors.groupingBy( Item::getCategory ) ).forEach( ( k, v ) -> {
          System.out.println( "key: " + k );
          System.out.println( "value: " + v );
          double av = v.stream().collect( Collectors.averagingDouble( priceFunc ) );
          System.out.println( k + " : " + av );
        } );

  }

  static class Item {
    private String name;
    private String category;
    private double price;

    public Item( String name, String category, double price ) {
      this.name = name;
      this.category = category;
      this.price = price;
    }

    public String getName() {
      return name;
    }

    public String getCategory() {
      return category;
    }

    public double getPrice() {
      return price;
    }

    @Override
    public String toString() {
      return "Item [name=" + name + ", category=" + category + ", price=" + price + "]";
    }

  }

}
