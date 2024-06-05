package arrays;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {

        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else {
                if (prices[i] - buy > maxProfit) {
                    maxProfit = prices[i] - buy;
                }
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
