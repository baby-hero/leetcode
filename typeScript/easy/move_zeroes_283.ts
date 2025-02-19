/*
 * https://leetcode.com/problems/move-zeroes/
 */
function moveZeroes(nums: number[]): number[] {
    let count_zero = 0;
    for(let i= 0; i< nums.length; i++) {
        if (nums[i] == 0) {
            count_zero += 1;
        } else {
            if (count_zero > 0) {
                nums[i- count_zero] = nums[i];
                nums[i] = 0;
            }
        }
    }
    return nums;
};

console.log(moveZeroes([0,1,0,3,12]));
console.log(moveZeroes([0]));