//Time complexity - O(n)
//Space complexity - O(n)
//Approach - create hashmap of a hashkey and list of strings which have have same hashkey, for hashkey create helper function which takes input string and return output string hash, hash is created as count of characters of each letter in string like abcc -> "1#1#2#0#...#" so it contains a count and of 26 charcters in string separated by hash.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store key -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = getKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        // Convert map values to a list of lists
        return new ArrayList<>(map.values());
    }

    // Build a key from character counts
    private String getKey(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        // Build a unique string that represents character frequency
        // Example: "aab" => count array [2, 1, 0, 0, ..., 0] => "2#1#0#0#...#"
        StringBuilder sb = new StringBuilder();
        for (int cnt : count) {
            sb.append(cnt).append('#');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        System.out.println("Grouped Anagrams for [eat, tea, tan, ate, nat, bat]:");
        System.out.println(result1);

        String[] strs2 = {"a"};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        System.out.println("\nGrouped Anagrams for [\"a\"]:");
        System.out.println(result2);

    }
}
