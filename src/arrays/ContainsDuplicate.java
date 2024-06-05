package arrays;

import java.util.*;

public class ContainsDuplicate {
//    public static boolean containsDuplicate(int[] nums) {
//
//        boolean isDuplicateAvailable = false;
//
//       // Arrays.sort(nums);
//
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int num : nums){
//            if(map.containsKey(num)){
//                isDuplicateAvailable = true;
//                break;
//            }else{
//                map.put(num,1);
//            }
//        }
//
//        return isDuplicateAvailable;
//    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for ( int num : nums){
            if (!seen.add(num))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println( containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
