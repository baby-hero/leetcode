#
# https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
#


class Solution:
    def reverseSubString(self, s, start, end):
        result = []
        i = start
        if start <= end:
            step = 1
        else:
            step = -1
        while True:
            if s[i] != '(' and s[i] != ")":
                result.append(s[i])
                i += step
            else:
                depth = self.depth_brackets[i]
                if depth % 2 == 0:
                    new_start = self.bracket_close_to_start_dict[i]
                    new_end = i
                    if new_start + 1 < new_end:
                        result.append(
                            self.reverseSubString(s, new_start + 1, new_end)
                        )
                    if new_start - 1 > end:
                        result.append(
                            self.reverseSubString(s, new_start - 1, end)
                        )
                    break
                else:
                    new_end = self.bracket_start_to_close_dict[i]
                    new_start = i
                    if new_end - 1 > new_start:
                        result.append(
                            self.reverseSubString(s, new_end - 1, new_start)
                        )
                    if new_end + 1 < end:
                        result.append(
                            self.reverseSubString(s, new_end + 1, end)
                        )
                    break
            if i == end:
                break
        return "".join(result)

    def reverseParentheses(self, s: str) -> str:
        self.bracket_start_to_close_dict = {}
        self.bracket_close_to_start_dict = {}
        self.depth_brackets = {}
        depth = 0
        stack = []
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
                depth += 1
            elif c == ')':
                start_i = stack.pop()
                if depth % 2 == 0:
                    self.bracket_close_to_start_dict[i] = start_i
                    self.depth_brackets[i] = depth
                else:
                    self.bracket_start_to_close_dict[start_i] = i
                    self.depth_brackets[start_i] = depth
                depth -= 1

        return self.reverseSubString(s, 0, len(s))


assert Solution().reverseParentheses("(abcd)") == "dcba"
assert Solution().reverseParentheses("(u(love)i)") == "iloveu"
assert Solution().reverseParentheses("(ed(et(oc))el)") == "leetcode"
assert Solution().reverseParentheses("vdgzyj()") == "vdgzyj"
assert Solution().reverseParentheses("((eqk((h))))") == "eqkh"
