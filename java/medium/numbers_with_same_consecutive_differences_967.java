import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> output = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            output.add(i);
        }
        int count = 1;
        while (count < n) {
            int i = 0;
            List<Integer> tempOutput = new ArrayList<>();
            while (i < output.size()) {
                int temp = output.get(i);
                int lastNumb = temp % 10;
                int a = lastNumb - k;

                if (a >= 0) {
                    int newA = temp * 10 + a;
                    tempOutput.add(newA);
                }
                if (k > 0) {
                    int b = lastNumb + k;
                    if (b <= 9) {
                        int newB = temp * 10 + b;
                        tempOutput.add(newB);
                    }
                }

                i++;
            }
            count++;
            output = tempOutput;
        }
        return output.stream().mapToInt(i -> i).toArray();
    }
}

/**
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/
 */
public class numbers_with_same_consecutive_differences_967 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result1 = solution.numsSameConsecDiff(3, 7);
        System.out.print("Result for n=3, k=7: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Expect: [181,292,707,818,929]

        int[] result2 = solution.numsSameConsecDiff(2, 1);
        System.out.print("Result for n=2, k=1: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Expect: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
    }
}