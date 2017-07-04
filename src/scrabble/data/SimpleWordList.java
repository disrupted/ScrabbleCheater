package scrabble.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SimpleWordList implements WordList {
  BufferedReader br;
  Collection<String> collection = new HashSet<>();

  @Override
  public Set<String> validWordsUsingAllTiles(String tileRackPart) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<String> allValidWords(String tileRack) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean add(String word) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(Collection<String> words) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size() {
    return collection.size();
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
        collection.add(currentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.addAll(collection);
    return this;
  }

}
