//Time complexity - O(n)
//Space complexity - O(n)
// Approach:
//    - Split strings from s by space
//    - Use a HashMap to track character to word mapping from pattern to s.
//    - Use a HashSet to track which strings in s are already mapped to ensure one-to-one mapping.

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        //split the string by spaces to get individual words
        String[] words = s.split(" ");

        //if the number of words doesn't match the length of pattern, they can't follow the same pattern
        if (words.length != pattern.length()) {
            return false;
        }

        //map for a character in pattern to its corresponding word
        HashMap<Character, String> charToWord = new HashMap<>();
        //set to keep track of which words have already been mapped
        HashSet<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (charToWord.containsKey(c)) {
                //if current character is already mapped, but the mapped word doesn't match the current word, pattern fails
                if (!charToWord.get(c).equals(w)) {
                    return false;
                }
            } else {
                //if the word is already mapped to another character, we cannot reuse it return false
                if (usedWords.contains(w)) {
                    return false;
                }
                //map the new character->word
                charToWord.put(c, w);
                usedWords.add(w);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern solver = new WordPattern();

        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println("Pattern: \"" + pattern1 + "\" | s: \"" + s1 + "\" -> "  + solver.wordPattern(pattern1, s1));

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println("Pattern: \"" + pattern2 + "\" | s: \"" + s2 + "\" -> "  + solver.wordPattern(pattern2, s2));
    }
}
