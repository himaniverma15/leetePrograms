package arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{3,4};
        double value = findMedianSortedArrays(num1,num2);
        System.out.println(value);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,mergedArray,0,nums1.length);
        System.arraycopy(nums2,0,mergedArray,nums1.length,nums2.length);
        Arrays.sort(mergedArray);

        int mergedArrayLength = mergedArray.length-1;

        Boolean isEven = mergedArrayLength%2 == 0 ? true : false;

        int mid = mergedArrayLength/2;

        if(isEven){
            return mergedArray[mid];
        }else{
            double result = (mergedArray[mid]+mergedArray[mid+1]);
            double b = result/2;
            return b;
        }
    }
}
