package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesInAnJava_442 {
    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0, n = nums.length, temp, num_correct_index;
        while (i < n) {
            num_correct_index = nums[i] - 1;
            if (nums[num_correct_index] != nums[i]) {
                temp = nums[i];
                nums[i] = nums[num_correct_index];
                nums[num_correct_index] = temp;
            } else {
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (i=0; i< n; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] input1 = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(input1)); // output: [2,3] 

        int[] input2 = {1, 2, 1};
        System.out.println(findDuplicates(input2)); // output [1]

        int[] input3 = {1};
        System.out.println(findDuplicates(input3)); // output []
    }
}
