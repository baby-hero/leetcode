package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber_287 {
    public static int findDuplicate(int[] nums) {
        Set<Integer> mumSet = new HashSet<>();
        for (int i=0; i < nums.length; i++) {
            if (!mumSet.contains(nums[i])) {
                mumSet.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] input1 = {1,3,4,2,2};
        System.out.println(findDuplicate(input1) == 2); 

        int[] input2 = {3,1,3,4,2};
        System.out.println(findDuplicate(input2) == 3); 

        int[] input3 = {3,3,3,3,3};
        System.out.println(findDuplicate(input3) == 3); 
    }
}
