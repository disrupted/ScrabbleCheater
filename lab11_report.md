# lab11 report: *Scrabble Cheater – Basic Edition*

**Salomon Popp**

## exercise 01

**Implement `initFromFile()` in [SimpleWordList](https://github.com/htw-imi-info2/ScrabbleCheater/blob/master/src/scrabble/data/SimpleWordList.java) that initializes the ScrabbleCheater from a given file. For now, simply store the words in a suitable Collection of the Java Collections Framework.**

#### Idea

- Collection: `HashSet`
- usage of a **BufferedReader** to parse file contents

#### Solution

```java
public class SimpleWordList implements WordList {
  private BufferedReader br;
  private Set<String> scrabbleWords = new HashSet<>();

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
```



## exercise 02

**Implement the `getNormalized()` and `equals()` methods in [Permutation](https://github.com/htw-imi-info2/ScrabbleCheater/blob/master/src/scrabble/util/Permutation.java). Two Permutations should be equal if one is a permutation of the other - regardless of the actual words they represent. Having a look at the provided test cases and making them run might help with the implementation.**

#### Idea

- `getNormalized()`: sort characters of Permutation
- equal if the normalized Strings are equal

#### Solution

```java
public String getNormalized() {
    if (permutation != null) {
      byte[] arr = permutation.getBytes();
      // Umsortieren
      Arrays.sort(arr);
      return new String(arr);
    }
    return "";
  }

  public boolean equals(Object obj) {
    return obj instanceof Permutation && obj.equals(this.getNormalized());
  }
```



## exercise 03

**To make the tests for Permutation work, also implement the methods that create Permutations in [PermutationUtilities](https://github.com/htw-imi-info2/ScrabbleCheater/blob/master/src/scrabble/util/PermutationUtilities.java)**

#### Solution

```java
  public static Set<String> getSubSets(String str) {
    Set<String> set = new TreeSet<>();
    int length = str.length();
    for (int c = 0; c < length; c++) {
      for (int i = 1; i < length - c; i++) {
        String sub = str.substring(c, c + i + 1);
        System.out.println(sub);
        if (!set.contains(sub))
          set.add(sub);
      }
    }
    return set;
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
```



## exercise 04

**now implement the `validWordsUsingAllTiles()` method in SimpleWordList that returns a Set of all the Words that are permutations of a given tile rack. That is, all words of the same length of the tile rack that can be build with it and that are in the word list, thus valid scrabble words.**

#### Idea

- iterate over all entries of our *scrabbleWords* collection
- check if the *normalized* String is equal to our *searchString*
- build new HashSet that stores the occurrences

#### Solution

```java
  public Set<String> validWordsUsingAllTiles(String tileRackPart) {
    Set<String> results = new HashSet<>();
    String searchString = new Permutation(tileRackPart).getNormalized();
    for (String word : scrabbleWords) {
      Permutation currentPerm = new Permutation(word);
      if (searchString.equals(currentPerm.getNormalized()))
        results.add(currentPerm.getWord());
    }
    return results;
  }
```



## exercise 05

**How can you use the Permutation class to make looking up the `validWordsUsingAllTiles()` more efficient? (Hint: how often will `getNormalized()` be called a) for initialisation and b) for a lookup in your WordList?)**

#### Idea

- a) once
- b) again once for every entry in *scrabbleWords*

#### Solution

- maybe we could just store the normalized version in a field variable for every Permutation object, but I skipped this step for now



## exercise 06

**Now, provide a second implementation of WordList using a HashMap as the underlying collection for storing the words. Note that you need to make sure that equals() and hashCode() work correctly on permutations in order to store Permutations at the same place in the HashMap.**

#### Idea

- `HashMap<String,String>`

#### Solution

```java
  public Set<String> validWordsUsingAllTiles(String tileRackPart) {
    Set<String> results = new HashSet<>();
    Permutation searchedPerm = new Permutation(tileRackPart);
    for (Map.Entry<String, String> entry : scrabbleWords.entrySet()) {
      if (searchedPerm.equals(new Permutation(entry.getKey())))
        results.add(entry.getValue());
    }
    return results;
  }
```

think this should've worked in theory, but unfortunately some of the test cases in *WordListTest* turned red and although I tried fixing it I just couldn't get the correct sizes.

![exercise06_WordListTest](exercise06_WordListTest.png)



## exercise 07

**You might want to add a main method or some sort of interface to input words that should be looked up by your scrabble cheater. (e.g. taking a parameter or reading in tile racks from standard in)**

#### Idea

- implement a basic *Scanner*
- didn't have the time to finish this – sorry !