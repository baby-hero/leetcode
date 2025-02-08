/*
 * https://leetcode.com/problems/single-number/
 */


function singleNumber(nums: number[]): number {
    let res = 0;
    nums.forEach(num => {
        res ^= num
    });
    return res;
};

console.log(singleNumber([2,2,1]));
console.log(singleNumber([4,1,2,1,2]));
console.log(singleNumber([1]));