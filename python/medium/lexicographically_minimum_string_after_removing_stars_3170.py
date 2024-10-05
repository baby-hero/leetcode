#
# https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars
#

class Solution:
    def clearStars(self, s: str) -> str:
        remove_indices = set()
        mark_indexs = {}
        for i, c in enumerate(s):
            c = s[i]
            if c != "*":
                if c not in mark_indexs:
                    mark_indexs[c] = []
                mark_indexs[c].append(i)
            else:
                remove_indices.add(i)
                min_key = min(mark_indexs.keys())
                if min_key and mark_indexs[min_key]:
                    remove_index = mark_indexs[min_key].pop()
                    remove_indices.add(remove_index)
                    if not mark_indexs[min_key]:
                        del mark_indexs[min_key]
        result = [c for i, c in enumerate(s) if i not in remove_indices]
        return "".join(result)


assert Solution().clearStars("aaba*") == "aab"
assert Solution().clearStars("abc") == "abc"
