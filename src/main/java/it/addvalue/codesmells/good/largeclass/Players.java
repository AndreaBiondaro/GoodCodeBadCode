package it.addvalue.codesmells.good.largeclass;

import java.util.ArrayList;
import java.util.List;

public class Players {
  private List<String> players = new ArrayList();

  private int[] places = new int[6];
  private int[] purses = new int[6];
  private boolean[] inPenaltyBox = new boolean[6];

  public int howManyPlayers() {
    return players.size();
  }

  public boolean add(String playerName) {
    players.add(playerName);
    places[howManyPlayers()] = 0;
    purses[howManyPlayers()] = 0;
    inPenaltyBox[howManyPlayers()] = false;

    System.out.println(playerName + " was added");
    System.out.println("They are player number " + players.size());
    return true;
  }

  public int getPlace(int playerNumber) {
    return places[playerNumber];
  }

  public void addToPlace(int playerNumber, int amount) {
    places[playerNumber] += amount;
  }

  public String getPlayerName(int playerNumber) {
    return players.get(playerNumber);
  }

  public int getPurse(int playerNumber) {
    return purses[playerNumber];
  }

  public void incrementPurse(int playerNumber) {
    purses[playerNumber]++;
  }

  public boolean isInPenaltyBox(int playerNumber) {
    return inPenaltyBox[playerNumber];
  }

  public void setInPenaltyBox(int playerNumber, boolean inPenaltyBox) {
    this.inPenaltyBox[playerNumber] = inPenaltyBox;
  }
}
