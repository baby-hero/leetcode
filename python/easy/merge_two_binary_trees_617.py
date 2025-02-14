#
# https://leetcode.com/problems/merge-two-binary-trees/description/description/
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
    def handleMerge(
        self, root1: Optional[TreeNode], root2: Optional[TreeNode]
    ):
        if root2:
            root1.val += root2.val
            if not root1.left:
                if root2.left:
                    root1.left = root2.left
            elif root2.left:
                self.handleMerge(root1.left, root2.left)

            if not root1.right:
                if root2.right:
                    root1.right = root2.right
            elif root2.right:
                self.handleMerge(root1.right, root2.right)

    def mergeTrees(
        self, root1: Optional[TreeNode], root2: Optional[TreeNode]
    ) -> Optional[TreeNode]:
        if not root1:
            return root2
        self.handleMerge(root1, root2)
        return root1
