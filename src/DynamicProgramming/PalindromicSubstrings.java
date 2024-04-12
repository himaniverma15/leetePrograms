package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

    public static int longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();

        int n = s.length();
        boolean[][] d = new boolean[n][n];

        for (int g = 0; g < n; g++) {

            for (int i = 0, j = g; j < n; i++, j++) {

                if (g == 0 ) {
                    d[i][j] = true;
                } else if (g == 1 ) {
                    d[i][j] =  (chars[i] == chars[j]);
                } else {
                   d[i][j] = (chars[i] == chars[j]) && d[i + 1][j - 1];
                }

                if (d[i][j]) {
                    list.add(s.substring(i, j + 1));
                }

            }
        }
        list.stream().forEach(e-> System.out.println(e));
        return list.size();
    }

    public static void main(String[] args) {
        int i = longestPalindrome("aabaa");
        System.out.println(i);
    }
}
