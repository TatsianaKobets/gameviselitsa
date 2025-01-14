package main.java.by.example.gameviselitsa;

public class HangmanDrawing {

  public void draw(int attempts) {
    System.out.println("  _______  ");
    System.out.println("  |     |  ");
    if (attempts > 0) {
      System.out.println("  |     O  ");
    }
    if (attempts > 1) {
      System.out.println("  |    /" + (attempts > 2 ? "|" : " ") + "\\  ");
    }
    if (attempts > 3) {
      System.out.println("  |     |  ");
    }
    if (attempts > 4) {
      System.out.println(
          "  |    / " + (attempts > 5 ? "\\" : " ") + " ");
    }
    if (attempts < 6) {
      System.out.println("  |    ___  ");
      System.out.println("__|___|___| ");
    } else {
      System.out.println("  |          ");
      System.out.println("__|________  ");
    }
  }
}
