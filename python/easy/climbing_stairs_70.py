#
# https://leetcode.com/problems/climbing-stairs/
#


class Solution:
    def climbStairs(self, n: int) -> int:
        a = 1
        b = 1
        res = 1
        for _ in range(1, n):
            res = a + b
            b = a
            a = res
        return res


assert Solution().climbStairs(2) == 2
assert Solution().climbStairs(3) == 3
