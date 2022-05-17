package it.addvalue.codesmells.good.longmethod;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GildedRose {
  private static final Class<Item> DEFAULT_CLASS = Item.class;

  private static final Map<String, String> SPECIALIZED_CLASSES =
      Map.of(
          "normal",
          Normal.class.getName(),
          "Aged Brie",
          Brie.class.getName(),
          "Backstage passes..",
          Backstage.class.getName());

  private List<Item> items;

  GildedRose(final List<Item> items) {
    this.items = items;
  }

  public void updateQuality() {
    this.items = items.stream().map(this::qualityUpdater).collect(Collectors.toList());
  }

  private Item qualityUpdater(final Item item) {
    Class<?> clazz;

    try {
      clazz = Class.forName(SPECIALIZED_CLASSES.get(item.getName()));
    } catch (final ClassNotFoundException e) {
      clazz = DEFAULT_CLASS;
    }

    try {
      return (Item)
          clazz
              .getConstructor(String.class, int.class, int.class)
              .newInstance(item.getName(), item.getQuality(), item.getDaysRemaining());
    } catch (final InstantiationException
        | NoSuchMethodException
        | IllegalAccessException
        | InvocationTargetException e) {
      // log failure for the item here
      e.printStackTrace();
    }

    // null item means it is unknown at the moment
    return null;
  }
}
