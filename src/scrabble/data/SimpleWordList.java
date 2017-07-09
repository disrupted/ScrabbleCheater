package scrabble.data;

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
  TreeSet<String> collection;

  public SimpleWordList() {
    collection = new TreeSet<>();
  }

  @Override
  public Set<String> validWordsUsingAllTiles(String tileRackPart) {
    // TODO Auto-generated method stub
    return new HashSet<String>();
  }

  @Override
  public Set<String> allValidWords(String tileRack) {
    // TODO Auto-generated method stub
    return new HashSet<String>();
  }

  @Override
  public boolean add(String word) {
    // TODO Auto-generated method stub
    if (collection.contains(word)) {
      return false;
    } else {
      collection.add(word);
      return true;
    }
  }

  @Override
  public boolean addAll(Collection<String> words) {
    return collection.addAll(words);
  }

  @Override
  public int size() {
    if (collection != null) {
      return collection.size();
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
        collection.add(currentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    addAll(collection);
    return this;
  }

}
