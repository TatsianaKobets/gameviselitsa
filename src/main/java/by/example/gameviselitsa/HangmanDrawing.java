package main.java.by.example.gameviselitsa;

public class HangmanDrawing {

  public void draw(int attempts) {
    System.out.println("  _______  ");
    System.out.println("  |     |  ");
    if (attempts > 0) {
      System.out.println("  |     O  "); // Голова
    }
    if (attempts > 1) {
      System.out.println("  |    /" + (attempts > 2 ? "|" : " ") + "\\  "); // Руки + грудь
    }
    if (attempts > 3) {
      System.out.println("  |     |  "); // Туловище
    }
    if (attempts > 4) {
      System.out.println(
          "  |    / " + (attempts > 5 ? "\\" : " ") + " "); // Левая нога + правая нога
    }
    if (attempts < 6) {
      System.out.println("  |    ___  "); // Стульчик
      System.out.println("  |   |   | ");
      System.out.println("__|___|___| ");
    } else {
      System.out.println("  |          ");
      System.out.println("__|________  ");
    }
  }
}
