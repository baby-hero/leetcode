#
# https://leetcode.com/problems/sum-of-square-numbers/description/
#

import math


class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        half_sqrt_c = int(math.sqrt(c/2))
        check_square_set = {i * i for i in range(0, half_sqrt_c + 2)}
        for i in range(half_sqrt_c, half_sqrt_c * 2 + 1):
            if (c - i * i) in check_square_set:
                print(f"{c} = {i * i} + {c - i * i}")
                return True
        return False


assert Solution().judgeSquareSum(c=0) == True
assert Solution().judgeSquareSum(c=1) == True
assert Solution().judgeSquareSum(c=2) == True
assert Solution().judgeSquareSum(c=3) == False
assert Solution().judgeSquareSum(c=4) == True
assert Solution().judgeSquareSum(c=5) == True
assert Solution().judgeSquareSum(c=8) == True
assert Solution().judgeSquareSum(c=9) == True
