#
# https://leetcode.com/problems/rotate-string/?envType=daily-question&envId=2024-11-03
#


class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False
        n = len(s)
        for step in range(-1, -n - 1, -1):
            if s[step] == goal[0]:
                if s[step:] + s[:step] == goal:
                    return True
        return False


print(Solution().rotateString(s='abcde', goal='cdeab') == True)
print(Solution().rotateString(s='abcde', goal='abced') == False)
print(Solution().rotateString(s='abcde', goal='abcde') == True)
