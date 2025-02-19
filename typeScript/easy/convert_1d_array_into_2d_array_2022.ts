/*
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 */


function construct2DArray(original: number[], m: number, n: number): number[][] {
    if (original.length == m*n) {
        return original.reduce(
            (res, _, i) => {
                if (i % n === 0) {
                    const row = original.slice(i, i + n);
                    res.push(row)
                }
                return res;
            },
            []
        );
    }
    return [];
};
console.log(construct2DArray([1,2,3,4],2, 2));
console.log(construct2DArray([1,2,3],1, 3));
console.log(construct2DArray([1,2],1, 1));