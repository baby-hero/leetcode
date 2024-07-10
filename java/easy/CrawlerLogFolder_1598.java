package easy;


/**
 * https://leetcode.com/problems/crawler-log-folder/
 */
 public class CrawlerLogFolder_1598 {
    
    public static int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) depth--;
            } else if (!log.equals("./")) {
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        // Test case 1
        String[] testArray1 = {"d1/","d2/","../","d21/","./"};
        System.out.println(minOperations(testArray1) == 2);

        // Test case 2
        String[] testArray2 = {"d1/","d2/","./","d3/","../","d31/"};
        System.out.println(minOperations(testArray2) == 3);

        // Test case 3
        String[] testArray3 = {"d1/","../","../","../"};
        System.out.println(minOperations(testArray3) == 0);
    }
}
