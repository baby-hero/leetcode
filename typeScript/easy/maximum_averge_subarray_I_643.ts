/*
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
function findMaxAverage(nums: number[], k: number): number {
    let total_k = 0, n= nums.length;
    for (let i=0; i < k; i++) {
        total_k += nums[i];
    }
    let max_total_k = total_k;
    for(let i = k; i< n; i++) {
        total_k += -nums[i-k] + nums[i];
        if (total_k > max_total_k) {
            max_total_k = total_k;
        }
    }
    return max_total_k / k;
};

console.log(findMaxAverage([1,12,-5,-6,50,3], 4));
console.log(findMaxAverage([5], 1));