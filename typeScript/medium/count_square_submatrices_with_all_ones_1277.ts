/*
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/?envType=daily-question&envId=2024-10-27
 */

function countSquares(matrix: number[][]): number {
    const n=matrix.length, m=matrix[0].length;
    const squareAtIJ: number[][] = Array.from(Array(n), () => Array(m).fill(0));
    const totalSquareAtIJ: number[][] = Array.from(Array(n), () => Array(m).fill(0));
    for (let i = 0; i < n; i++) {
        squareAtIJ[i][0] = matrix[i][0];
        if (i == 0) {
            totalSquareAtIJ[i][0] = matrix[i][0];
        } else {
            totalSquareAtIJ[i][0] = totalSquareAtIJ[i - 1][0] + matrix[i][0];
        }
    }
    for (let j = 1; j < m; j++) {
        squareAtIJ[0][j] = matrix[0][j];
        totalSquareAtIJ[0][j] = totalSquareAtIJ[0][j - 1] + matrix[0][j];
    }

    for (let i = 1; i < n; i++) {
        for (let j = 1; j < m; j++) {
            if (matrix[i][j] == 1) {
                squareAtIJ[i][j] = 1 + Math.min(squareAtIJ[i][j-1], squareAtIJ[i- 1][j -1], squareAtIJ[i- 1][j])

            }
            totalSquareAtIJ[i][j] = squareAtIJ[i][j] + totalSquareAtIJ[i][j -1] + totalSquareAtIJ[i-1][j] - totalSquareAtIJ[i-1][j-1]
        }
    }
    return totalSquareAtIJ[n - 1][m - 1];
};

// console.log(countSquares(
//     [
//         [0,1,1,1],
//         [1,1,1,1],
//         [0,1,1,1]
//     ]
// ));  // output: 15
// console.log(countSquares(
//     [
//         [1,0,1],
//         [1,1,0],
//         [1,1,0]
//     ]
// )); // output: 7
// console.log(countSquares(
//     [
//         [0,0,0],
//         [0,1,0],
//         [0,1,0],
//         [1,1,1],
//         [1,1,0]
//     ]
// )); // output: 8