package it.addvalue.codesmells.good.largeclass;

import java.util.LinkedList;

public class Questions {
  private LinkedList<String> popQuestions = new LinkedList();
  private LinkedList<String> scienceQuestions = new LinkedList();
  private LinkedList<String> sportsQuestions = new LinkedList();
  private LinkedList<String> rockQuestions = new LinkedList();

  public Questions() {
    for (int i = 0; i < 50; i++) {
      popQuestions.addLast("Pop Question " + i);
      scienceQuestions.addLast(("Science Question " + i));
      sportsQuestions.addLast(("Sports Question " + i));
      // In questo caso non viene più usato il metodo perché se si nota all'interno fa lo stesso che
      // avviene per
      // le altre domande.
      rockQuestions.addLast("Rock Question " + i);
    }
  }

  // Questo metodo è il risultato del metodo askQuestion
  public String getNextQuestion(String category) {
    switch (category) {
      case "Pop":
        return popQuestions.removeFirst();
      case "Science":
        return scienceQuestions.removeFirst();
      case "Sports":
        return sportsQuestions.removeFirst();
      case "Rock":
        return rockQuestions.removeFirst();
      default:
        return null;
    }
  }
}
