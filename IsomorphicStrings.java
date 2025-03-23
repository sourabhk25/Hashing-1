//Time complexity - O(n)
//Space complexity - O(n)
// Approach:
//    - Use a HashMap to track character mapping from s to t.
//    - Use a HashSet to track which characters in t are already mapped
//      to ensure one-to-one mapping.


import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> valueSet = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sMap.containsKey(sChar)) {
                if(sMap.get(sChar) != tChar) {  //duplicate entry from s char but with different value
                    return false;
                }
            } else {
                if(valueSet.contains(tChar)) {
                    return false;
                }
                sMap.put(sChar, tChar);
                valueSet.add(tChar);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings checker = new IsomorphicStrings();

        String s1 = "egg";
        String t1 = "add";
        System.out.println("Are \"" + s1 + "\" and \"" + t1 + "\" isomorphic? "
                + checker.isIsomorphic(s1, t1));

        String s2 = "paper";
        String t2 = "title";
        System.out.println("Are \"" + s2 + "\" and \"" + t2 + "\" isomorphic? "
                + checker.isIsomorphic(s2, t2));

        String s3 = "badc";
        String t3 = "baba";
        System.out.println("Are \"" + s3 + "\" and \"" + t3 + "\" isomorphic? "
                + checker.isIsomorphic(s3, t3));

    }
}
