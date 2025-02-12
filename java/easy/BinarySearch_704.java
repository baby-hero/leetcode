package easy;


/**
 * https://leetcode.com/problems/counting-bits/description/
 */


public class BinarySearch_704 {
    public static int search(int[] nums, int target) {
        int l =0, r=nums.length -1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                if (nums[mid] < target) {
                    l = mid + 1;
                }
                else {
                    return mid;
                }
            }
        }   
        return -1;
    }
    public static void main(String[] args) {
        // Test case 1
        int[] input1 = {-1,0,3,5,9,12};
        System.out.println(search(input1, 9) == 4);

        // Test case 2
        int[] input2 = {-1,0,3,5,9,12};
        System.out.println(search(input2, 2) == -1);
    }
}
