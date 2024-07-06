#
# https://leetcode.com/problems/pass-the-pillow/description
#


class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        div, mod = divmod(time, n - 1)
        if div % 2 == 0:
            return mod + 1
        else:
            return n - mod


assert Solution().passThePillow(n=4, time=5) == 2
assert Solution().passThePillow(n=3, time=2) == 3
assert Solution().passThePillow(n=18, time=38) == 5
