package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int k =0; k<nums.length;k++)
            dp[k]=1;
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int previous = 0;
            while(previous<i) {
                if(nums[previous]<nums[i]){
                    dp[i]= Math.max(dp[i],dp[previous] +1);
                }
                previous++;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
