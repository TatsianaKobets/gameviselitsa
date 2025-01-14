package main.java.by.example.gameviselitsa;

import java.util.Scanner;

public class GameViselitsa {

  private static final int MAX_ATTEMPTS = 6;
  private String word;
  private Player player;
  private WordProvider wordProvider;
  private HangmanDrawing hangmanDrawing;

  public GameViselitsa() {
    this.wordProvider = new WordProvider();
    this.hangmanDrawing = new HangmanDrawing();
    this.word = wordProvider.getRandomWord();
    this.player = new Player(word.length());
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);

    while (player.getWrongAttempts() < MAX_ATTEMPTS && player.isWordIncomplete()) {
      displayCurrentState();
      System.out.print("Введите букву: ");
      String input = scanner.nextLine().trim();

      if (input.isEmpty() || input.length() > 1 || !Character.isLetter(input.charAt(0))) {
        System.out.println("Пожалуйста, введите только одну букву.");
        continue;
      }

      char guess = Character.toLowerCase(input.charAt(0));
      if (player.getGuessedLetters().contains(guess)) {
        System.out.println("Вы уже угадали эту букву. Попробуйте другую.");
        continue;
      }

      player.makeGuess(guess, word);

      if (player.isGuessCorrect(guess, word)) {
        System.out.println("Правильная буква!");
      } else {
        player.incrementWrongAttempts();
        System.out.println("Неправильная буква!");
      }
    }
    displayCurrentState();
    displayResult();
  }

  private void displayCurrentState() {
    System.out.println("Текущее состояние: " + player.getCurrentGuess());
    System.out.println("Ошибки: " + player.getWrongAttempts() + "/" + MAX_ATTEMPTS);
    hangmanDrawing.draw(player.getWrongAttempts());
    System.out.println("Вы выбрали буквы: " + player.getGuessedLetters());
  }

  private void displayResult() {
    if (player.getCurrentGuess().equals(word)) {
      System.out.println("Поздравляем, вы угадали слово: " + word);
    } else {
      System.out.println("Вы проиграли! Загаданное слово: " + word);
    }
  }
}
