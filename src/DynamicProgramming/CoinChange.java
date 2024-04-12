package DynamicProgramming;

public class CoinChange {
    public static void main(String[] args) {
        coinChange(new int[]{1,2,5}, 11);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;

            for(int j = 0 ; j < coins.length;j++){
                if(i >= coins[j] && dp[i-coins[j]]!=-1){
                    min = Math.min(min, dp[i-coins[j]]+1);
                }
            }

            dp[i]= min ==Integer.MAX_VALUE ? -1 : min;
        }
        System.out.println(dp[amount]);
        return dp[amount];
    }

}
