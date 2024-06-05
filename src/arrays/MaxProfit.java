//package arrays;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class MaxProfit {
////    public int maxProfit(int[] prices) {
////        if (prices == null || prices.length == 0) {
////            return 0;
////        }
////
////        int minPrice = prices[0];
////        int maxProfit = 0;
////
////        for (int i = 1; i < prices.length; i++) {
////            // Update minPrice if we find a lower price
////            if (prices[i] < minPrice) {
////                minPrice = prices[i];
////            } else {
////                // Calculate profit if we sell on the current day
////                int profit = prices[i] - minPrice;
////                // Update maxProfit if the current profit is greater
////                if (profit > maxProfit) {
////                    maxProfit = profit;
////                }
////            }
////        }
////
////        return maxProfit;
////    }
//
//    public static int maxProfit(List<Integer> prices)
//    {
//        int n = prices.size();
//
//        // 2D DP array to store max profit with 0 and 1
//        // stocks
//        int[][] dp = new int[n][2];
//
//        dp[0][0] = -prices.get(0);
//        dp[0][1] = 0;
//
//        // Loop through prices to calculate max profit at
//        // each day
//        for (int i = 1; i < n; i++) {
//            // choice 1: Buy the stock at i, in which case
//            // the profit we get is the maximum profit we
//            // could have made till i-1 minus the price at
//            // i.
//            dp[i][0]
//                    = Math.max(dp[i - 1][0], -prices.get(i));
//
//            // choice 2: Sell the stock at i, in which case
//            // the profit we get is the maximum profit we
//            // could have made till i-1 by buying the stock
//            // earlier plus the price at i.
//            dp[i][1] = Math.max(
//                    dp[i - 1][1], dp[i - 1][0] + prices.get(i));
//        }
//
//        // Return the maximum profit calculated from the
//        // last day
//        return Math.max(dp[n - 1][0], dp[n - 1][1]);
//    }
//
//    public static void main(String[] args) {
//        MaxProfit solution = new MaxProfit();
//
//        int[] prices1 = {7, 1, 5, 3, 6, 4};
//        System.out.println("Max Profit for prices1: " + solution.maxProfit(Arrays.asList(7, 1, 5, 3, 6, 4))); // Output: 5
//
////        int[] prices2 = {7, 6, 4, 3, 1};
////        System.out.println("Max Profit for prices2: " + solution.maxProfit(prices2)); // Output: 0
//    }
//}
