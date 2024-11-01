package medium;

/**
 * https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/?envType=daily-question&envId=2024-10-29
 */

public class MaximumNumberOfMovesInAGrid_2684 {
    public static int maxMoves(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] maxGrid = new int[n][m];
        
        int maxMove = 1, tmp;
        for (int i=0;i<n;i++) {
            maxGrid[i][0] = 1;
        }

        boolean flagCol;
        for (int j=1; j<m; j++) {
            flagCol = false;
            // row 0
            for (int f=0; f < 2; f++) {
                if (grid[0][j] > grid[f][j-1] && maxGrid[f][j-1] > 0) {
                    tmp = maxGrid[f][j-1] + 1;
                    if (tmp > maxGrid[0][j]) {
                        maxGrid[0][j] = tmp;
                    }
                    if (tmp > maxMove) {
                        maxMove = tmp;
                    }
                    flagCol = true;
                }
            }
            // row 1 to n - 2
            for (int i = 1; i < n -1; i++) {
                for (int f=-1; f < 2; f++) {
                    if (grid[i][j] > grid[i-f][j-1] && maxGrid[i-f][j-1] > 0) {
                        tmp = maxGrid[i-f][j-1] + 1;
                        if (tmp > maxGrid[i][j]) {
                            maxGrid[i][j] = tmp;
                        }
                        if (tmp > maxMove) {
                            maxMove = tmp;
                        }
                        flagCol = true;
                    }
                }
            }
            // row n-1
            for (int f=n-2; f < n; f++) {
                if (grid[n-1][j] > grid[f][j-1] && maxGrid[f][j-1] > 0) {
                    tmp = maxGrid[f][j-1] + 1;
                    if (tmp > maxGrid[n-1][j]) {
                        maxGrid[n-1][j] = tmp;
                    }
                    if (tmp > maxMove) {
                        maxMove = tmp;
                    }
                    flagCol = true;
                }
            }
            if (!flagCol) {
                break;
            }
        }

        for (int[] row : maxGrid) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        return maxMove - 1;
    }

    public static void main(String[] args) {
        // test 1
        int[][] grid1 = {{2,4,3,5}, {15,4,9,3}, {3,4,2,11}, {10,9,13,15}};
        System.out.println(maxMoves(grid1)); // Output: 3

        // test 2
        int[][] grid2 = {{3,2,4},{2,1,9},{1,1,7}};
        System.out.println(maxMoves(grid2)); // Output: 0
    }
}
