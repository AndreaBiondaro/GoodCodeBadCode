package it.addvalue.codesmells.bad.longmethod;

// Code taken from:
// https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/Java/src/main/java/com/gildedrose/Item.java

public class Item {

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
