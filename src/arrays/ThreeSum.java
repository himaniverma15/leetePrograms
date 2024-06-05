package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {

    public static List<List<Integer>> threeSumWithOmgaOfN3Complexity(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> list = new ArrayList<>();
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
           int j = i+1;
           int k = nums.length -1;

           while (j!=k){
               List<Integer> list = new ArrayList<>();
               int sum = nums[i] + nums[j] + nums[k];
               if (sum == 0) {
                   list.add(nums[i]);
                   list.add(nums[j]);
                   list.add(nums[k]);
                   result.add(list);
                   k--;
               }

               if(sum > 0){
                   k--;
               }

               if(sum < 0){
                   j++;
               }
           }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    }
}
