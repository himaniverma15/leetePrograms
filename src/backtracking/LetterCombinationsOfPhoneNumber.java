package backtracking;

import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations(new String("")));
    }

        private static final String[] digitToLetters = {"", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {

        List<String> permutations = new ArrayList<>();

        dfs(digits, 0, permutations, new StringBuffer());

        return permutations;
    }

    private static void dfs(String digits, int index, List<String> permutations, StringBuffer sb) {

        if (index == digits.length()) {
            permutations.add(sb.toString());
            return;
        }

        for (final char c : digitToLetters[digits.charAt(index) - '0'].toCharArray()) {

            sb.append(c);

            dfs(digits, index + 1, permutations, sb);

            sb.deleteCharAt(sb.length()-1);

        }

    }
}
