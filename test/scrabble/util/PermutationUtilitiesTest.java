package scrabble.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class PermutationUtilitiesTest {

  @Test
  public void testPermutationsAreRandom() {
    String word = "hellothere";
    String p1 = PermutationUtilities.createPermutation(word);
    String p2 = PermutationUtilities.createPermutation(word);
    if (p1.equals(p2)) {
      System.out.println("hit the rare (1/" + word.length()
              + "!) case that 2 permutations are the same!");
      p2 = PermutationUtilities.createPermutation(word);
      assertFalse("permutations should be random", p1.equals(p2));
    }
  }

}
