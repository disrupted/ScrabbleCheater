package scrabble.data;

import scrabble.util.Permutation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SimpleWordList implements WordList {
  private BufferedReader br;
  private HashMap<String, String> scrabbleWords;

  public SimpleWordList() {
    scrabbleWords = new HashMap<>();
  }

  @Override
  public Set<String> validWordsUsingAllTiles(String tileRackPart) {
    Set<String> results = new HashSet<>();
    Permutation searchedPerm = new Permutation(tileRackPart);
    for (Map.Entry<String, String> entry : scrabbleWords.entrySet()) {
      if (searchedPerm.equals(new Permutation(entry.getKey())))
        results.add(entry.getValue());
    }
    return results;
  }

  @Override
  public Set<String> allValidWords(String tileRack) {
    // TODO Auto-generated method stub
    return new HashSet<String>();
  }

  @Override
  public boolean add(String word) {
    if (word == null || word.isEmpty()) {
      return false;
    } else {
      scrabbleWords.put(new Permutation(word).getNormalized(), word);
      return true;
    }
  }

  @Override
  public boolean addAll(Collection<String> words) {
    if (words == null || words.isEmpty())
      return false;
    for (String word : words) {
      add(word);
    }
    return true;
  }

  @Override
  public int size() {
    if (scrabbleWords != null) {
      return scrabbleWords.size();
    } else {
      return 0;
    }
  }

  @Override
  public WordList initFromFile(String fileName) {
    try {
      br = new BufferedReader(new FileReader(fileName));
    } catch (FileNotFoundException e) {
      System.out.println(fileName + " wasn't found.");
      e.printStackTrace();
    }
    String currentLine;
    try {
      while ((currentLine = br.readLine()) != null) {
        // System.out.println(currentLine);
        add(currentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return this;
  }

}
