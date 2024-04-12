package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {


        int count = 0;
        int k = -1;

        int[] dp = new int[text1.length()];

        for (int i = 0; i < text1.length(); i++) {

            for (int j = 0; j < text2.length(); j++) {

                if (text1.charAt(i) == text2.charAt(j) && j > k) {
                    dp[i] = ++count;
                    k =j;
                    break;
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}
