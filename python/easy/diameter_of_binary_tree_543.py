#
# https://leetcode.com/problems/diameter-of-binary-tree/
#

# Definition for a binary tree node.
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.res = 0

        def getDepthByNode(node: Optional[TreeNode]) -> int:
            if not node:
                return 0

            depth_left = getDepthByNode(node.left)
            depth_right = getDepthByNode(node.right)

            self.res = max(self.res, depth_left + depth_right)
            return max(depth_left, depth_right) + 1

        getDepthByNode(root)
        return self.res
