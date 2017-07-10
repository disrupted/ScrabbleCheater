package scrabble.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PermutationUtilities {

  /**
   * creates a set with all subsets of the input string
   *
   * @param str
   * @return
   */
  public static Set<String> getSubSets(String str) {
    return Permutation.generateSubSets(str);
  }

  public static String createPermutation(int length) {
    // build List that contains all letters from a-z & A-Z
    List<String> asciiChars = new ArrayList<>(26 * 2);
    for (char c = 'A'; c <= 'z'; c++)
      if (c <= 'Z' || c >= 'a')
        asciiChars.add(String.valueOf(c));

    StringBuilder sb = new StringBuilder(length);
    Random rand = new Random();
    // append random ascii letters
    for (int i = 1; i <= length; i++) {
      sb.append(asciiChars.get(rand.nextInt(asciiChars.size())));
    }
    return sb.toString();
  }

  public static String createPermutation(String p) {
    return new Permutation(p).getPermutation();
  }
}
