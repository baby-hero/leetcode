package easy;

/**
 * https://leetcode.com/problems/is-subsequence/description/
 */

public class IsSubsequence_392 {

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0, n = s.length(), m = t.length();
        while (i < n) {
            while (j < m && s.charAt(i) !=  t.charAt(j)) {
                j++;
            }
            if (j >= m) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(isSubsequence("abc", "ahbgdc"));
        // Test case 2
        System.out.println(isSubsequence("axc", "adbgdc"));
        // Test case 2
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
        System.out.println(isSubsequence("adfa", ""));
    }
}
