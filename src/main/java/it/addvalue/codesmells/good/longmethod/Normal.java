package it.addvalue.codesmells.good.longmethod;

public class Normal extends Item {

  Normal(final String name, final int quality, final int daysRemaining) {
    super(name, quality, daysRemaining);
  }

  @Override
  protected void tick() {
    daysRemaining--;

    if (quality == 0) {
      return;
    }

    quality--;

    if (daysRemaining <= 0) {
      quality--;
    }
  }
}
