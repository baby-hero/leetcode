package easy;


/**
 * https://leetcode.com/problems/backspace-string-compare/
 */


public class BackspaceStringCompare_844 {
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder tBuilder = new StringBuilder();
        int size = Math.min(s.length(), t.length());

        for (int i=0; i < size; i++) {
            if (s.charAt(i) == '#'){
                if (sBuilder.length() > 0) {
                    sBuilder.deleteCharAt(sBuilder.length()-1);
                }
            } else {
                sBuilder.append(s.charAt(i));
            }

            if (t.charAt(i) == '#' ) {
                if (tBuilder.length() > 0) {
                    tBuilder.deleteCharAt(tBuilder.length()-1);
                }
            } else {
                tBuilder.append(t.charAt(i));
            }
        }
        if (s.length() > size) {
            for (int i = size; i < s.length(); i ++) {
                if (s.charAt(i) == '#'){
                    if (sBuilder.length() > 0) {
                        sBuilder.deleteCharAt(sBuilder.length()- 1);
                    }
                } else {
                    sBuilder.append(s.charAt(i));
                }
            }
        }

        if (t.length() > size) {
            for (int i = size; i < t.length(); i ++) {
                if (t.charAt(i) == '#' ) {
                    if (tBuilder.length() > 0) {
                        tBuilder.deleteCharAt(tBuilder.length()- 1);
                    }
                } else {
                    tBuilder.append(t.charAt(i));
                }
            }
        }
        return sBuilder.toString().equals(tBuilder.toString());
    }
    public static void main(String[] args) {
        // Test case 1
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));


        // Test case 2
        System.out.println(backspaceCompare("ab##", "c#d#"));

        // Test case 3
        System.out.println(backspaceCompare("a#c", "b") == false);
    }
}
