#
# https://leetcode.com/problems/water-bottles/description
#


class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        numb_water_bottles = numBottles
        while numBottles >= numExchange:
            div, remainder = divmod(numBottles, numExchange)
            numb_water_bottles += div
            numBottles = remainder + div
        print(f"result: {numb_water_bottles}")
        return numb_water_bottles


assert Solution().numWaterBottles(numBottles=9, numExchange=3) == 13
assert Solution().numWaterBottles(numBottles=15, numExchange=4) == 19
