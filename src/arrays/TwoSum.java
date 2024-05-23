package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
* */
public class TwoSum {
    public static Object[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                result.add(i);
                result.add(map.get(target - nums[i]));
                break;
            }
        }
        return result.toArray();
    }


    public static void main(String[] args) {
        Object[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (Object res : result) {
            System.out.println(res);
        }

    }
}
