package it.addvalue.codesmells.good.largeclass;

public class Game {
  Questions questions = new Questions();
  Players players = new Players();

  int currentPlayer = 0;
  boolean isGettingOutOfPenaltyBox;

  public Game() {}

  public boolean isPlayable() {
    return (players.howManyPlayers() >= 2);
  }

  public void roll(int roll) {
    System.out.println(players.getPlayerName(currentPlayer) + " is the current player");
    System.out.println("They have rolled a " + roll);

    if (players.isInPenaltyBox(currentPlayer)) {
      if (roll % 2 != 0) {
        isGettingOutOfPenaltyBox = true;

        System.out.println(
            players.getPlayerName(currentPlayer) + " is getting out of the penalty box");
        players.addToPlace(currentPlayer, roll);
        if (players.getPlace(currentPlayer) > 11) {
          players.addToPlace(currentPlayer, -12);
        }

        System.out.println(
            players.getPlayerName(currentPlayer)
                + "'s new location is "
                + players.getPlace(currentPlayer));
        System.out.println("The category is " + currentCategory());
        askQuestion();
      } else {
        System.out.println(
            players.getPlayerName(currentPlayer) + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
      }
    } else {
      players.addToPlace(currentPlayer, roll);
      if (players.getPlace(currentPlayer) > 11) {
        players.addToPlace(currentPlayer, -12);
      }

      System.out.println(
          players.getPlayerName(currentPlayer)
              + "'s new location is "
              + players.getPlace(currentPlayer));
      System.out.println("The category is " + currentCategory());
      askQuestion();
    }
  }

  private void askQuestion() {
    String question = questions.getNextQuestion(currentCategory());
    System.out.println(question);
  }

  private String currentCategory() {
    switch (players.getPlace(currentPlayer)) {
      case 0:
      case 4:
      case 8:
        return "Pop";
      case 1:
      case 5:
      case 9:
        return "Science";
      case 2:
      case 6:
      case 10:
        return "Sports";
      default:
        return "Rock";
    }
  }

  public boolean wasCorrectlyAnswered() {
    if (players.isInPenaltyBox(currentPlayer)) {
      if (isGettingOutOfPenaltyBox) {
        System.out.println("Answer was correct!!!!");
        players.incrementPurse(currentPlayer);
        System.out.println(
            players.getPlayerName(currentPlayer)
                + " now has "
                + players.getPurse(currentPlayer)
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.howManyPlayers()) currentPlayer = 0;

        return winner;
      } else {
        currentPlayer++;
        if (currentPlayer == players.howManyPlayers()) currentPlayer = 0;
        return true;
      }
    } else {
      System.out.println("Answer was correct!!!!");
      players.incrementPurse(currentPlayer);
      System.out.println(
          players.getPlayerName(currentPlayer)
              + " now has "
              + players.getPurse(currentPlayer)
              + " Gold Coins.");

      boolean winner = didPlayerWin();
      currentPlayer++;
      if (currentPlayer == players.howManyPlayers()) currentPlayer = 0;

      return winner;
    }
  }

  public boolean wrongAnswer() {
    System.out.println("Question was incorrectly answered");
    System.out.println(players.getPlayerName(currentPlayer) + " was sent to the penalty box");
    players.setInPenaltyBox(currentPlayer, true);

    currentPlayer++;
    if (currentPlayer == players.howManyPlayers()) currentPlayer = 0;
    return true;
  }

  private boolean didPlayerWin() {
    return players.getPurse(currentPlayer) != 6;
  }
}
