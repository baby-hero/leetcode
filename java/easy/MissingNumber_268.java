package easy;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber_268 {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int result = n * (n + 1) / 2;
        for (Integer i : nums) {
            result -= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] input1 = {3, 0, 1};
        System.out.println(missingNumber(input1) == 2);

        // Test case 2
        int[] input2 = {0,1};
        System.out.println(missingNumber(input2) == 2);
    }
}
