package main.java.by.example.gameviselitsa;

import java.util.HashSet;
import java.util.Set;

public class Player {

  private StringBuilder currentGuess;
  private Set<Character> guessedLetters;
  private int wrongAttempts;

  public Player(int wordLength) {
    this.currentGuess = new StringBuilder("_".repeat(wordLength));
    this.guessedLetters = new HashSet<>();
    this.wrongAttempts = 0;
  }

  public void makeGuess(char letter, String word) {
    guessedLetters.add(letter);
    if (word.indexOf(letter) >= 0) {
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == letter) {
          currentGuess.setCharAt(i, letter);
        }
      }
    }
  }

  public boolean isGuessCorrect(char letter, String word) {
    return word.indexOf(letter) >= 0;
  }

  public void incrementWrongAttempts() {
    wrongAttempts++;
  }

  public int getWrongAttempts() {
    return wrongAttempts;
  }

  public boolean isWordIncomplete() {
    return currentGuess.toString().contains("_");
  }

  public String getCurrentGuess() {
    return currentGuess.toString();
  }

  public Set<Character> getGuessedLetters() {
    return guessedLetters;
  }
}
