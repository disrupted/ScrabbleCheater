package scrabble.util;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

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

  @Test
  public void testSubStrings() {
    String word = "permuta";
    Set<String> permutatitons = PermutationUtilities.getSubSets(word);
    System.out.println(permutatitons);
    assertFalse("Sub sets shouldn't be empty", permutatitons.isEmpty());
  }

  @Test
  public void testCreatePermutationsWithCorrectLength() {
    int stringTargetLength = 200;
    String result = PermutationUtilities.createPermutation(stringTargetLength);
    System.out.println(result);
    assertTrue("should only contain letters", result.matches("[a-zA-Z]+"));
    assertEquals("wrong length", stringTargetLength, result.length());
  }

}
