package medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf_238 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] accToEnd = new int[n];
        accToEnd[n - 1] = 1;
        for (int i=n - 2; i >=0; i--) {
            accToEnd[i] = accToEnd[i + 1] * nums[i + 1];
        }
        int accMul = 1;
        for (int i =0; i < n; i ++) {
            result[i] = accMul * accToEnd[i];
            accMul *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(input1))); // Output: [24,12,8,6]
        
        int[] input2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(input2))); // Output: [0,0,9,0,0]
    }
}
