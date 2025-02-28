package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */


public class SetMatrixZeroes_73 {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Set<Integer> zero_rows = new HashSet<>();
        Set<Integer> zero_cols = new HashSet<>();
        for (int i=0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    zero_rows.add(i);
                    zero_cols.add(j);
                }
            }
        }

        for (int row: zero_rows) {
            for (int  j=0; j < m; j++) {
                matrix[row][j] = 0;
            }
        }
        for(int j: zero_cols) {
            for (int i=0; i < n; i ++) {
                matrix[i][j] = 0;
            }
        }
    }
}
