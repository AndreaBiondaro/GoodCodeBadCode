package it.addvalue.codesmells.good.longmethod;

public class Backstage extends Item {

  Backstage(final String name, final int quality, final int daysRemaining) {
    super(name, quality, daysRemaining);
  }

  @Override
  protected void tick() {
    daysRemaining--;

    if (quality >= 50) {
      return;
    }

    if (daysRemaining < 0) {
      quality = 0;
    }

    quality++;

    if (daysRemaining < 10) {
      quality++;
    }

    if (daysRemaining < 5) {
      quality++;
    }
  }
}
