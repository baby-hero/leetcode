/*
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */

class NumArray {
    private sum_numbs: number[];
    constructor(nums: number[]) {
        this.sum_numbs = Array.of(nums.length + 1).fill(0);
        for(let i=0; i< nums.length; i++) {
            this.sum_numbs[i+1] = this.sum_numbs[i] + nums[i];
        }
    }

    sumRange(left: number, right: number): number {
        return this.sum_numbs[right + 1] - this.sum_numbs[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */