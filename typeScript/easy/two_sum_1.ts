/*
 * https://leetcode.com/problems/two-sum/
 */
function twoSum(nums: number[], target: number): number[] {
    const nums_map = new Map<number, number>();
    for (let i = 0; i < nums.length; i++) {
        if (nums_map.has(target - nums[i])) {
            return [nums_map.get(target - nums[i]), i];
        } else {
            nums_map.set(nums[i], i);
        }
    }
};

console.log(twoSum([2, 7, 11, 15], 9));
console.log(twoSum([3, 2, 4], 6));
console.log(twoSum([3, 3], 6));