package easy;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */


public class FindSmallestLetterGreaterThanTarget_744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l=0, r = letters.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (letters[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l >= letters.length) {
            return letters[0];
        }
        return letters[l];
    }

    public static void main(String[] args) {
        // Test case 1
        char[] input1 = {'c','f','j'};

        System.out.println(nextGreatestLetter(input1, 'a') == 'c');

        // Test case 2
        char[] input2 = {'x', 'x', 'y', 'y', 'y'};
        System.out.println(nextGreatestLetter(input2, 'z') == 'x');
    }
}
