package main.java.by.example.gameviselitsa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordProvider {

  final List<String> words;
  final Random random = new Random();
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
      Logger.getLogger(WordProvider.class.getName()).log(Level.SEVERE, "Ошибка загрузки слов", e);
    }
    return words;
  }

  public String getRandomWord() {
    return words.get(random.nextInt(words.size()));
  }
}
