/*
 * https://leetcode.com/problems/contains-duplicate/
 */
function containsDuplicate(nums: number[]): boolean {
    let nums_set = new Set();
    for (let num of nums) {
        if (nums_set.has(num)) {
            return true;
        }
        nums_set.add(num);
    }
    return false;
};

console.log(containsDuplicate([1,2,3,1]) === true);
console.log(containsDuplicate([1,2,3,4]) === false);
