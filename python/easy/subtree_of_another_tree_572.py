#
# https://leetcode.com/problems/same-tree/description/
#

# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def equalTree(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        if not root1 and not root2:
            return True

        if not root1 or not root2 or root1.val != root2.val:
            return False

        return (
            self.equalTree(root1.left, root2.left) and
            self.equalTree(root1.right, root2.right)
        )

    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root:
            if root.val == subRoot.val and self.equalTree(root, subRoot):
                return True
            else:
                if (
                    self.isSubtree(root.left, subRoot) or
                    self.isSubtree(root.right, subRoot)
                ):
                    return True
        return False
