package medium;

/*
 * https://leetcode.com/problems/word-search/
*/

public class WordSearch_79 {
    private boolean recursive(
        char[][] board, String word,
        int x, int y, 
        int n, int m,
        int w_index)
    {
        if (x >= 0 && y >= 0 && x < n && y < m && board[x][y] == word.charAt(w_index)) {
            if (w_index == (word.length() -1)) {
                return true;
            }

            char tmp = board[x][y];
            board[x][y] = '.';
            if (
                recursive(board, word, x - 1, y, n, m,  w_index + 1) ||
                recursive(board, word, x + 1, y, n, m,  w_index + 1) ||
                recursive(board, word, x, y - 1 , n, m,  w_index + 1) ||
                recursive(board, word, x, y + 1 , n, m,  w_index + 1)
            ) {
                return true;
            }
            board[x][y] = tmp;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length, m=board[0].length;
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (recursive(board, word, i, j, n, m, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
