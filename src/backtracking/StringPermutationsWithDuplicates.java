package backtracking;

import java.util.*;

public class StringPermutationsWithDuplicates {
    public static void main(String[] args) {
        String string = "aab";
        char[] chars =string.toCharArray();
        Arrays.sort(chars);
        string = new String(chars);
        List permutations = permutate(string, "", new ArrayList<>());
        permutations.stream().forEach(e -> System.out.println(e));
    }
    static List<String> permutate(String str, String permute, List permutations ) {

        if (str.length() == 0) {
            permutations.add(permute);
        }
        Set<String> charOccured = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
            if (!charOccured.contains(Character.toString(ch))) {
                String temp = str.substring(0, i) + str.substring(i + 1);
                permutate(temp, permute + ch, permutations);
            }
            charOccured.add(Character.toString(ch));
        }
        return permutations;
    }
}
