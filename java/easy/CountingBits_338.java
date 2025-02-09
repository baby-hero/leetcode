package easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/description/
 */

public class CountingBits_338 {

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        int mul2 = 1, i = 1;
        while (i <= n) {
            for(int j=0; j < mul2; j++) {
                res[i] = res[j] + 1;
                i++;
                if (i > n) {
                    break;
                }
            }
            mul2 = mul2 * 2;
        }
        return res;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(Arrays.toString(countBits(2)));

        // Test case 2
        System.out.println(Arrays.toString(countBits(5)));
    }
    
}
