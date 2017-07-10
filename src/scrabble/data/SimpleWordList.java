package scrabble.data;

import scrabble.util.Permutation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SimpleWordList implements WordList {
  private BufferedReader br;
  private TreeSet<String> scrabbleWords;

  public SimpleWordList() {
    scrabbleWords = new TreeSet<>();
  }

  @Override
  public Set<String> validWordsUsingAllTiles(String tileRackPart) {
    HashSet<String> results = new HashSet<>();
    String searchString = new Permutation(tileRackPart).getNormalized();
    for (String word : scrabbleWords) {
      Permutation currentPerm = new Permutation(word);
      if (searchString.equals(currentPerm.getNormalized()))
        results.add(currentPerm.getWord());
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
    if (word == null || scrabbleWords.contains(word)) {
      return false;
    } else {
      scrabbleWords.add(word);
      return true;
    }
  }

  @Override
  public boolean addAll(Collection<String> words) {
    return scrabbleWords.addAll(words);
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
      e.printStackTrace();
    }
    String currentLine;
    try {
      while ((currentLine = br.readLine()) != null) {
        System.out.println(currentLine);
        scrabbleWords.add(currentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    addAll(scrabbleWords);
    return this;
  }

}
