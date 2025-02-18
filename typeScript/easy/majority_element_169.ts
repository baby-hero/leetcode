/*
 * https://leetcode.com/problems/majority-element/
 */

function quickSort(nums: number[], l: number, r: number, n: number){
    let i = l;
    let j = r;
    let mark = nums[Math.floor((l + r) / 2)];
    while (i <= j) {
        while (i < n && nums[i] < mark) {
            i++;
        }
        while (j > 0 && nums[j] > mark) {
            j--;
        }
        if (i <= j) {
            const temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    if (l < j) {
        quickSort(nums, l, j, n);
    }
    if (i < r) {
        quickSort(nums, i, r, n);
    }
}

function majorityElement(nums: number[]): number {
    quickSort(nums, 0, nums.length - 1, nums.length);
    return nums[Math.floor(nums.length / 2)]
};
const input = [2,2,1,3,1,1,4,1,1,5,1,1,6]
console.log(majorityElement(input) === 1);

console.log(majorityElement([6, 5, 5]) === 5);

console.log(majorityElement([3, 3, 4]) === 3);
console.log(majorityElement([3, 2, 3]) === 3);
console.log(majorityElement([2, 2, 1, 1, 1, 2, 2]) === 2);