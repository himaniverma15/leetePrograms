package arrays;

public class ContainerWithMostWater {
    //    public static int maxArea(int[] height) {
//
//        int left = 0, right = height.length - 1;
//        int maxWaterContainerCanHold = 0;
//
//        while (right > left) {
//
//            if (height[left] < height[right]) {
//
//                maxWaterContainerCanHold = maxWaterContainerCanHold < height[left] * ((right + 1) - (left + 1)) ?
//                        height[left] * ((right + 1) - (left + 1)) : maxWaterContainerCanHold;
//                int product = height[left] * ((right + 1) - (left + 1));
//                System.out.println(height[left] + "*" + ((right + 1) - (left + 1)) + "=" + product);
//
//                right--;
//            } else {
//
//                maxWaterContainerCanHold = maxWaterContainerCanHold < height[right] * ((right + 1) - (left + 1)) ?
//                        height[right] * ((right + 1) - (left + 1)) : maxWaterContainerCanHold;
//                int product =  height[right] * ((right + 1) - (left + 1));
//                System.out.println(height[right] + "*" + ((right + 1) - (left + 1)) + "=" + product);
//                right--;
//            }
//
//            if (right == left) {
//                right = height.length - 1;
//                left++;
//            }
//        }
//
//        return maxWaterContainerCanHold;
//    }
    public static int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            final int minHeight = Math.min(height[l], height[r]);
            ans = Math.max(ans, minHeight * (r - l));
            if (height[l] < height[r])
                ++l;
            else
                --r;
        }

        return ans;
    }

    public static void main(String[] args) {
        // [2,3,4,5,18,17,6]
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        ;
//        System.out.println(maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
        ;
    }
}
