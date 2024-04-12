package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinPairSelectedForMinValue {
    public static void main(String[] args) {
        coinChange(new int[]{1, 2, 5}, 11);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Map<Integer, List> map = new HashMap<>();
        List<Integer> coinsSelectedToFullfillAmt = new ArrayList<>();
        coinsSelectedToFullfillAmt.add(0);
        map.put(0, coinsSelectedToFullfillAmt);

        for (int i = 1; i < dp.length; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                coinsSelectedToFullfillAmt = new ArrayList<>();
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    coinsSelectedToFullfillAmt.add(coins[j]);
                    int index = i - coins[j];
                    int remaingAmot = dp[index];
                    List<Integer> list = map.get(index);
                    coinsSelectedToFullfillAmt.addAll(list);
                    map.put(i, coinsSelectedToFullfillAmt);
                    min = Math.min(min, remaingAmot + 1);
                }
            }

            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        System.out.println(dp[amount]);
        System.out.println(map.get(amount));
        return dp[amount];
    }

}
