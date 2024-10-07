package easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-string-length-after-removing-substrings
 */
public class MinimumStringLengthAfterRemovingSubstrings_2696 {

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i= 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else {
                char pre_char = stack.peek();
                if (
                    (pre_char == 'A' && c == 'B')
                    || (pre_char == 'C' && c == 'D')
                ) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(minLength("ABFCACDB") == 2);

        // Test case 2
        System.out.println(minLength("ACBBD") == 5);
    }
}
