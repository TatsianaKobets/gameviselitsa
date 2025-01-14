package main.java.by.example.gameviselitsa;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean playAgain;

    do {
      GameViselitsa game = new GameViselitsa();
      game.start();
      System.out.print("Хотите сыграть еще раз? (да/нет): ");
      playAgain = scanner.nextLine().equalsIgnoreCase("да");
    } while (playAgain);

    scanner.close();
    System.out.println("Спасибо за игру!");
  }
}
