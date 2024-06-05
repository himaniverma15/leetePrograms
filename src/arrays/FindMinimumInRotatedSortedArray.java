package arrays;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left< right){

             mid = (left+right)/2;

            if(nums[mid] < nums[right]){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));

    }
}
