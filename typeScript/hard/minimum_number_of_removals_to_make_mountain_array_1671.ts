/*
 *  https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/?envType=daily-question&envId=2024-10-30
*/

function minimumMountainRemovals(nums: number[]): number {
    const n = nums.length;
    let topStackIndex: number = 0;
    const ascendingStack = Array(n);
    const left: number[] = Array(n);
    const right: number[] = Array(n);

    ascendingStack[topStackIndex] = nums[0];
    left[0] = 1;
    for (let i=1; i < n; i++) {
        if (nums[i] > ascendingStack[topStackIndex]) {
            topStackIndex++;
            ascendingStack[topStackIndex] = nums[i];
        } else {
            let j = topStackIndex - 1;
            while (j >= 0 && ascendingStack[j] >= nums[i]) {
                j--;
            }
            j = j + 1;
            ascendingStack[j] = nums[i];
        }
        left[i] = topStackIndex + 1
    }

    topStackIndex = 0
    ascendingStack[topStackIndex] = nums[n - 1];
    right[n - 1] = 1;
    for (let i=n-2; i >= 0; i--) {
        if (nums[i] > ascendingStack[topStackIndex]) {
            topStackIndex++;
            ascendingStack[topStackIndex] = nums[i];
        } else {
            let j = topStackIndex - 1;
            while (j >= 0 && ascendingStack[j] >= nums[i]) {
                j--;
            }
            j = j + 1;
            ascendingStack[j] = nums[i];
        }
        right[i] = topStackIndex + 1
    }
    let maxMountainSize = 0;
    for (let i=1; i < n-1; i++) {
        if (left[i] > 1 && right[i] > 1 && maxMountainSize < (left[i] + right[i] - 1)) {
            maxMountainSize = left[i] + right[i] - 1;
        }
    }
    return n - maxMountainSize;
};

console.log(minimumMountainRemovals([1,3,1]) == 0);
console.log(minimumMountainRemovals([2,1,1,5,6,2,3,1]) == 3);
console.log(minimumMountainRemovals([9,8,1,7,6,5,4,3,2,1]) == 2);
console.log(minimumMountainRemovals([100,92,89,77,74,66,64,66,64]) == 6);
console.log(minimumMountainRemovals([1,2,1,3,4,4]) == 3);




