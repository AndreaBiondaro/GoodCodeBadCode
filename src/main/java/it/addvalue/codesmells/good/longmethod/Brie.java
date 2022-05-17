package it.addvalue.codesmells.good.longmethod;

public class Brie extends Item {

  Brie(final String name, final int quality, final int daysRemaining) {
    super(name, quality, daysRemaining);
  }

  @Override
  protected void tick() {
    daysRemaining--;

    if (quality >= 50) {
      return;
    }

    quality++;

    if (daysRemaining <= 0) {
      quality++;
    }
  }
}
