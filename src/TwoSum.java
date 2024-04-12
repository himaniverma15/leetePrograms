import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int[] index = new int[2];
        int target = 9;
//        index = twoSum(arr, target,index);
//       for(int i =0 ; i< index.length ; i++){
//           System.out.println(i);
//       }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int a= 0; a < nums.length ; a++){
            map.put(nums[a],a);
        }

        for(int i = 0; i< nums.length;i++){
            int secondNumber = target - nums[i];

            Integer indexx = map.get(secondNumber);

            if(indexx!=null &&
                    indexx!= i &&
                           indexx!=0){

                index[0] = i; index[1] = indexx;
                break;
            }
        }
        return index;
    }
}
