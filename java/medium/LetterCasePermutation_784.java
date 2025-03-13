package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/letter-case-permutation/description/
*/
public class LetterCasePermutation_784 {
    private static void recursive(int i, String s, StringBuffer sb, List<String> res) {
        if (i == s.length()) {
            res.add(sb.toString());
            return;
        }
        char c = s.charAt(i);
        sb.append(c);
        recursive(i + 1, s, sb, res); 
        sb.setLength(i);
        if (
            (c>= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z')
        ) {
            int diff = 32;
            if (c >='a') {
                diff = -32;
            }
            sb.append((char)(c + diff));
            recursive(i + 1, s, sb, res);
            sb.setLength(i);
        }
    }
    public static List<String> letterCasePermutation(String s) {
        StringBuffer sb = new StringBuffer();
        List<String> res = new ArrayList<>();
        recursive(0, s, sb, res);
        return res;
    }
    public static void main(String[] avrg) {
        System.out.println((letterCasePermutation("a1b1")));
    }
}
