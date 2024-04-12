package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        nums = Arrays.stream(nums).distinct().toArray();
        List<Integer> list = new ArrayList<>();

        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.isEmpty()){
                count+=1;
                map.put(num,count);
            }else {
                Integer integer =  map.get(num-1);
                if(integer!=null){
                    map.remove(num-1);
                    map.put(num,integer+1);
                }else {
                    count=0;
                    map.put(num,count+1);
                }
            }
        }

        Optional<Integer> max = map.values().stream().sorted(Comparator.reverseOrder()).findFirst();
        return max.isPresent()?max.get():0;
    }
}
