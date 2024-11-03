package easy;

/**
 * https://leetcode.com/problems/crawler-log-folder/
 */
public class DeleteCharactersToMakeFancyString_19957 {
    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char preChar = s.charAt(0);
        for (char curChar: s.toCharArray()) {
            if (preChar == curChar) {
                count++;
                if (count >= 3) {
                    continue;
                }
                sb.append(curChar);
            } else {
                count = 1;
                preChar = curChar;
                sb.append(curChar);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // Test case 1
        System.out.println(makeFancyString("leeetcode").equals("leetcode"));

        // Test case 2
        System.out.println(makeFancyString("aaabaaaa").equals("aabaa"));

        // Test case 3
        System.out.println(makeFancyString("aab").equals("aab"));
    }
}
