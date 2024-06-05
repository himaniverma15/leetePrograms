package arrays;

public class ProductOfArrayExceptSelf {
//    public static int[] productExceptSelf(int[] nums) {
//
//        int pos = 0, index = 0, product = 1;
//
//        int[] result = new int[nums.length];
//
//        while (pos != nums.length) {
//
//            if (index == nums.length) {
//                result[pos] = product;
//                index = 0;
//                product = 1;
//                pos++;
//            }
//
//            if (index != pos) {
//                product = product * nums[index];
//            }
//            index++;
//        }
//
//        return result;
//    }
//

    public static int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];

        prefix[0] = nums[0];
        for (int p = 1; p < nums.length; p++) {
            prefix[p] = prefix[p - 1] * nums[p];
        }

        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int s = nums.length - 2; s >= 0; s--) {
            suffix[s] = suffix[s + 1] * nums[s];
        }

        for (int r = 0; r < nums.length; r++) {
            if(r == 0){
                result[r] = suffix[r+1];
            }else if(r == nums.length -1){
                result[nums.length -1 ] = prefix[r-1];
            }else{
                result[r] = prefix[r-1] * suffix[r+1];
            }
        }
        return result;
    }


//    public static int[] productExceptSelf(int[] nums) {
//        final int n = nums.length;
//        int[] ans = new int[n];
//        ans[0] = 1;
//
//        // Use ans as the prefix product array.
//        for (int i = 1; i < n; ++i)
//            ans[i] = ans[i - 1] * nums[i - 1];
//
//        int suffix = 1; // suffix product
//        for (int i = n - 1; i >= 0; --i) {
//            ans[i] *= suffix;
//            suffix *= nums[i];
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
