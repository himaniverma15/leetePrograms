package DynamicProgramming;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {

        System.out.println(longestPalindromeSubseq("bccd"));
    }


//    public static int longestPalindromeSubseq(String S)
//    {
//        int[][] dp = new int[S.length()][S.length()];
//
//        for (int i = S.length() - 1; i >= 0; i--) {
//            dp[i][i] = 1;
//            for (int j = i+1; j < S.length(); j++) {
//                if (S.charAt(i) == S.charAt(j)) {
//                    dp[i][j] = dp[i+1][j-1] + 2;
//                } else {
//                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[0][S.length()-1];
//    }


    public static int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }


//    public static int longestPalindromeSubseq(String s) {
//        int[][] dp = new int[s.length()][s.length()];
//
//        for (int g = 0; g < s.length(); g++) {
//            for (int i = 0, j = g; j < s.length(); i++, j++) {
//                if (g == 0) {
//                    dp[i][j] = 1;
//                } else if (g == 1) {
//                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
//                } else {
//                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 + dp[i + 1][j - 1] : 1;
//                }
//            }
//        }
//        return dp[0][s.length() - 1];
//    }
}
