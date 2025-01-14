package main.java.by.example.gameviselitsa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordProvider {

  private List<String> words;

  public WordProvider() {
    this.words = loadWords();
  }

  private List<String> loadWords() {
    List<String> words = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/words.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        words.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return words;
  }

  public String getRandomWord() {
    Random random = new Random();
    return words.get(random.nextInt(words.size()));
  }
}
