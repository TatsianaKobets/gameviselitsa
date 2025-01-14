package main.java.by.example.gameviselitsa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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

    while (player.getWrongAttempts() <= MAX_ATTEMPTS && player.isWordIncomplete()) {
      displayCurrentState();
      System.out.print("Введите букву: ");
      String input = scanner.nextLine().trim();

      if (input.isEmpty()) {
        System.out.println("Вы должны ввести букву.");
        continue;
      }

      char guess = input.charAt(0);
      player.makeGuess(guess, word);

      if (player.isGuessCorrect(guess, word)) {
        System.out.println("Правильная буква!");
      } else {
        player.incrementWrongAttempts();
      }
    }

    displayResult();
  }

  private void displayCurrentState() {
    System.out.println("Текущее состояние: " + player.getCurrentGuess());
    System.out.println("Ошибки: " + player.getWrongAttempts() + "/" + MAX_ATTEMPTS);
    hangmanDrawing.draw(player.getWrongAttempts());
    System.out.println("Угаданные буквы: " + player.getGuessedLetters());
  }

  private void displayResult() {
    if (player.getCurrentGuess().equals(word)) {
      System.out.println("Поздравляем, вы угадали слово: " + word);
    } else {
      System.out.println("Вы проиграли! Загаданное слово: " + word);
    }
  }
}
