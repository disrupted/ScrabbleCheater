package scrabble.util;


import java.util.*;

public class Permutation {
  private String permutation;
  private String original;
  //private Set<String> permutations = new HashSet<String>();

  public Permutation(String original) {
    this.original = original;
    this.permutation = generateRandom(original);
    //this.permutations = generatePermutations(original);
  }

  public static Set<String> generatePermutations(String input) {
    Set<String> set = new HashSet<>();
    if (input.isEmpty())
      return set;

    char a = input.charAt(0);

    if (input.length() > 1) {
      input = input.substring(1);

      Set<String> permSet = generatePermutations(input);

      for (String x : permSet) {
        for (int i = 0; i <= x.length(); i++) {
          set.add(x.substring(0, i) + a + x.substring(i));
        }
      }
    } else {
      set.add(String.valueOf(a));
    }
    return set;
  }

  /* public static Set<String> generatePermutations(String str) {
    return generatePermutations("", str);
  } */

  /* public static Set<String> generatePermutations(String prefix, String str) {
    Set<String> set = new HashSet<String>();
    int n = str.length();
    if (n == 0) set.add(prefix);
    else {
      Set<String> permSet;
      for (int i = 0; i < n; i++) {
        permSet = generatePermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        set.add(Arrays.toString(permSet.toArray()));
      }
    }
    return set;
  } */

  private static String generateRandom(String original) {
    if (original.isEmpty())
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
    return obj instanceof Permutation && obj.equals(this.getNormalized());
  }

  @Override
  public String toString() {
    return getWord() + " / " + getNormalized();
  }

  public String getNormalized() {
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
