package backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsWithoutDuplicates {
    public static void main(String[] args) {
        String str = "abc";
        List<String> list = new ArrayList<>();
        dfs(str, "", list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void dfs(String str, String perm, List<String> list) {
        if (str.length() == 0) {
            list.add(perm);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String f = str.substring(0, i);
            String s = str.substring(i + 1);
            String tmp = f + s;
            dfs(tmp, perm + ch, list);
        }
    }
}
