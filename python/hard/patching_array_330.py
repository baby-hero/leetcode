#
# https://leetcode.com/problems/patching-array/
#

from typing import List


class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        patches = 0
        next_i = 0
        max_sum_i = 0
        while max_sum_i < n:
            if next_i < len(nums) and nums[next_i] <= (max_sum_i + 1):
                max_sum_i += nums[next_i]
                next_i += 1
            else:
                max_sum_i += (max_sum_i + 1)
                patches += 1
        print(patches)
        return patches


assert Solution().minPatches(nums=[1, 3], n=6) == 1
assert Solution().minPatches(nums=[1, 5, 10], n=20) == 2
assert Solution().minPatches(nums=[1, 2, 2], n=5) == 0
