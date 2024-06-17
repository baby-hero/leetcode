#
# https://leetcode.com/problems/distribute-money-to-maximum-children/description/
#


class Solution:
    def distMoney(self, money: int, children: int) -> int:
        money = money - children

        if money < 0:
            return -1

        max_childrens = money // 7
        remainder = money % 7
        if max_childrens > children:
            max_childrens = children
            remainder = money - max_childrens * 7

        children_remainder = children - max_childrens

        if children_remainder == 0 and remainder > 0:
            max_childrens -= 1
            remainder += 7

        if children_remainder == 1 and remainder == 3:
            max_childrens -= 1

        print(max_childrens)
        return max_childrens


assert Solution().distMoney(money=20, children=3) == 1
assert Solution().distMoney(money=16, children=2) == 2
