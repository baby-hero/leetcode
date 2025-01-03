/*
 *
 * https://leetcode.com/problems/number-of-ways-to-split-array/description/
 */

function waysToSplitArray(nums: number[]): number {
    const n = nums.length;
    const cum_sum = Array(n + 1).fill(0);
    for (let i= 0; i < n; i ++) {
        cum_sum[i + 1] = cum_sum[i] + nums[i];
    }
    let res = 0, sum_left, sum_right;
    for (let i=0; i < n -1; i++) {
        sum_left = cum_sum[i + 1];
        sum_right = cum_sum[n] - sum_left;
        if (sum_left >= sum_right) {
            res += 1;
        }
    }
    return res;
};

console.log(waysToSplitArray(
    [10, 4, -8, 7]
));
