package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */

public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int i, j, r=0, c=0, count=0, n=matrix.length, m=matrix[0].length, size=n*m;
        while (true) {
            for(j=c; j< m; j++) {
                result.add(matrix[r][j]);
                count++;
            }
            if (count >= size) {
                break;
            }
            r++;
            for(i=r; i<n; i++) {
                result.add(matrix[i][m]);
                count++;
            }
            if (count >= size) {
                break;
            }
            m--;
            for (j =m; j >= c; j--) {
                result.add(matrix[n][j]);
                count ++;
            }
            if (count >= size) {
                break;
            }
            n--;
            for (i=n;i>=r; i++) {
                result.add(matrix[i][c]);
                count++;
            }
            if (count >= size) {
                break;
            }
            c++;
        }
        return result;
    }
}
