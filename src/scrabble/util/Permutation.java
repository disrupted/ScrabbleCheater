package scrabble.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Permutation {
  private String permutation;
  private String original;

  public Permutation(String original) {
    this.original = original;
    this.permutation = generateRandom(original);
  }

  private static String generateRandom(String original) {
    if (original == null)
      return "";
    List<Character> characters = new ArrayList<>();
    for (char c : original.toCharArray()) {
      characters.add(c);
    }
    StringBuilder output = new StringBuilder(original.length());
    while (characters.size() != 0) {
      int randPicker = (int) (Math.random() * characters.size());
      output.append(characters.remove(randPicker));
    }
    return output.toString();
  }

  @Override
  public int hashCode() {
    // TBD: implement this method
    if (permutation != null) {
      byte[] bytes = permutation.getBytes();
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
    return Objects.equals(obj, this.getNormalized());
  }

  @Override
  public String toString() {
    return getWord() + " / " + getNormalized();
  }

  public String getNormalized() {
    // TBD: implement this method
    if (permutation != null) {
      byte[] arr = permutation.getBytes();
      // Umsortieren
      Arrays.sort(arr);
      return new String(arr);
    }
    return "";
  }

  public String getWord() {
    // TBD: implement this method
    return original;
  }

  public String getPermutation() {
    return permutation;
  }

  public int length() {
    // TBD: implement this method
    return original.length();
  }

}
