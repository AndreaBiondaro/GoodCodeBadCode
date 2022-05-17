package it.addvalue.codesmells.good.longmethod;

public class Item {

  private final String name;
  protected int quality;
  protected int daysRemaining;

  Item(final String name, final int quality, final int daysRemaining) {
    this.name = name;
    this.quality = quality;
    this.daysRemaining = daysRemaining;
  }

  protected void tick() {}

  public String getName() {
    return name;
  }

  public int getDaysRemaining() {
    return daysRemaining;
  }

  public int getQuality() {
    return quality;
  }
}
