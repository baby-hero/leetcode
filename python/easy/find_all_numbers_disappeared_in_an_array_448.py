#
# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
#


from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []
        nums = set(nums)
        for i in range(1, n + 1):
            if i not in nums:
                result.append(i)
        return result


assert Solution().findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]) == [5, 6]
assert Solution().findDisappearedNumbers([1, 1]) == [2]
