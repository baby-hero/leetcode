#
# https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
#

# Definition for a binary tree node.
from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        result = 0
        queue: List[TreeNode] = []
        if root:
            queue.append(root)
        while queue:
            result += 1
            size = len(queue)
            for _ in range(0, size):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return result


root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
Solution().maxDepth(root)
