package medium;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-search/
*/

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num: nums) {
            numsSet.add(num);
        }

        int result = 0, preNum;
        for (Integer num: numsSet) {
            if (!numsSet.contains(num + 1)) {
                preNum = num - 1;
                while (numsSet.contains(preNum)) {
                    preNum--;
                }
                preNum = num - preNum;
                if (preNum > result) {
                    result = preNum;
                }
            }
        }
        return result;
    }
}
