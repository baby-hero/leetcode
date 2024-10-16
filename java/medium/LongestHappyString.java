package medium;

/**
 * https://leetcode.com/problems/longest-happy-string/description/
 */
public class LongestHappyString {

    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        char[] chars = {'a', 'b', 'c'};
        int[] remainChars = {a, b, c};
        int prevIndex= 0, selectIndex=0, i;

        // find previous index
        for (i= 1; i < 3; i++) {
            if (remainChars[selectIndex] < remainChars[i]) {
                selectIndex = i;
            }
        }
        int retry = 2;
        while (remainChars[selectIndex] > 0 && retry > 0) {
            sb.append(chars[selectIndex]);
            remainChars[selectIndex]--;
            retry--;
        }
        prevIndex = selectIndex;
        int maxRemainchar = 1;
        while (maxRemainchar > 0) {
            // find maximum but not pre characters
            maxRemainchar = -1;
            for (i = 0; i < 3; i++) {
                if (i != prevIndex && maxRemainchar < remainChars[i]) {
                    selectIndex = i;
                    maxRemainchar = remainChars[i];
                }
            }
            if (remainChars[selectIndex] - remainChars[prevIndex] > 0) {
                sb.append(chars[selectIndex]);
                remainChars[selectIndex]--;    
            }
            if (remainChars[selectIndex] > 0) {
                sb.append(chars[selectIndex]);
                remainChars[selectIndex]--;
            }

            prevIndex = selectIndex;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7)); // Output: "ccaccbcc"
        System.out.println(longestDiverseString(7, 1, 0)); // Output: "aabaa"
        System.out.println(longestDiverseString(0, 8, 11)); // Output: "ccbccbccbbccbbccbbc"
    }
}
