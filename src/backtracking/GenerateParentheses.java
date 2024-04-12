package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, 3);
        System.out.println(result);
    }
    public static  List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private static void generate(List<String> result, String s, int open, int close, int n) {

        if (open == n && close == n) {
            result.add(s);
            return;
        }

        if (open < n) {
            generate(result, s + "(", open+1, close, n);
        }

        if (close < open) {
            generate(result, s + ")", open, close+1, n);
        }
    }
}
