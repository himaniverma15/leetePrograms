package DynamicProgramming;

public class NoOfWaysCoinChange {
    public static void main(String[] args) {

        System.out.println(change(10, new int[]{2, 5, 3, 6}));
    }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        //rows
        for (int i = 0; i < coins.length; i++) {
            //columns
            for (int j = 0; j < amount + 1; j++) {
                //column value ==0 set all 1
                if (j == 0) {
                    dp[i][j] = 1;
                }

                if (coins[i] <= j) {
                    dp[i][j] = dp[i][j - coins[i]];
                    if (i != 0) {
                        dp[i][j] = dp[i][j] + dp[i - 1][j];
                    }
                } else {
                    if (i != 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[coins.length-1][amount];
    }


}
