package medium;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */

public class RotateImage_48 {
    private static void swapArr(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
    public static void rotate(int[][] matrix) {
        int i,j,left = 0, top=0, right = matrix.length - 1, bottom= right;
        while (left < right && top < bottom) {
            i = top;
            for (j=left; j<right;j++) {
                swapArr(matrix, top, j, i, right);
                i++;
            }

            i = top + 1;
            for (j=right - 1; j>=left;j--) {
                swapArr(matrix, top, j, i, left);
                i++;
            }
            
            j = left + 1;                
            for(i=top + 1; i<=bottom; i++) {
                swapArr(matrix, i, left, bottom, j);
                j++;
            }

            left++;
            right--;
            top++;
            bottom--;
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(input);
    }
}
