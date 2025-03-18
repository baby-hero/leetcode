#
# https://leetcode.com/problems/permutations/
#

from typing import List, Set


class Solution:
    def recursive(
        self, nums: List[int],
        arr: Set[int], i: int, n: int, rs: List[List[int]]
    ):
        if (i == n):
            rs.append(arr.copy())
        else:
            for j in range(0, n):
                if (nums[j] > -11):
                    arr[i] = nums[j]
                    nums[j] = -11
                    self.recursive(nums, arr, i + 1, n, rs)
                    nums[j] = arr[i]

    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        result: List[List[int]] = []
        arr = nums.copy()
        self.recursive(nums, arr, 0, n, result)
        return result
