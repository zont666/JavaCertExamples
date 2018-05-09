package threads.immutable;

public final class ImmutableRGB {

  final private int red, green, blue;
  final private String name;

  private void check( int r, int g, int b ) {
    if ( r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255 ) {
      throw new IllegalArgumentException();
    }
  }

  public ImmutableRGB( int red, int green, int blue, String name ) {
    check( red, green, blue );
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.name = name;
  }

  public int getRGB() {
    System.out.println( Thread.currentThread().getName() + ": getting RGB" );
    return ((red << 16) | (green << 8) | blue);
  }

  public String getName() {
    System.out.println( Thread.currentThread().getName() + ": getting colour name" );
    return name;
  }

  public ImmutableRGB invert() {
    return new ImmutableRGB( 255 - red, 255 - green, 255 - blue, "Inverse of " + name );
  }

}
