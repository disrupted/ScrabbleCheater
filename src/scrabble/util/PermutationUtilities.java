package scrabble.util;

import java.util.HashSet;
import java.util.Set;

public class PermutationUtilities {

  /**
   * creates a set with all subsets of the input string
   *
   * @param str
   * @return
   */
  public static Set<String> getSubSets(String str) {
    return new HashSet<String>();
  }

  public static String createPermutation(int length) {
    return null;
  }

  public static String createPermutation(String p) {
    Permutation perm = new Permutation(p);
    return perm.getPermutation();
  }
}
