#
# https://leetcode.com/problems/best-sightseeing-pair/description/
#

from typing import List


class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        n = len(values)
        suffixMax = [0] * n
        suffixMax[n-1] = values[n-1] - (n-1)
        for i in range(n-2, -1, -1):
            suffixMax[i] = max(suffixMax[i + 1], values[i] - i)
        result = 0
        for i in range(n - 1):
            if values[i] + i + suffixMax[i + 1] > result:
                result = values[i] + i + suffixMax[i + 1]
        return result


assert Solution().maxScoreSightseeingPair([8, 1, 5, 2, 6]) == 11
assert Solution().maxScoreSightseeingPair([1, 2]) == 2
