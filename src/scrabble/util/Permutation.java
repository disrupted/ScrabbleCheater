package scrabble.util;


import java.util.Arrays;

public class Permutation {
  String word;

  public Permutation(String word) {
    this.word = word;
  }

  @Override
  public int hashCode() {
    // TBD: implement this method
    if (word != null) {
      byte[] bytes = word.getBytes();
      int result = 0;
      for (byte aByte : bytes) {
        result += aByte;
      }
      return result;
    }
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    //TBD: Implement equals method
    return obj.equals(this.getNormalized());
  }

  @Override
  public String toString() {
    return getWord() + " / " + getNormalized();
  }

  public String getNormalized() {
    // TBD: implement this method
    if (word != null) {
      byte[] arr = word.getBytes();
      // Umsortieren
      Arrays.sort(arr);
      return new String(arr);
    }
    return "";
  }

  public String getWord() {
    // TBD: implement this method
    return word;
  }

  public int length() {
    // TBD: implement this method
    return word.length();
    //return 0;
  }

}
