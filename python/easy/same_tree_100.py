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
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if p is None:
            return q is None
        else:
            if q is not None:
                return (
                    p.val == q.val and
                    self.isSameTree(p.left, p.left) and
                    self.isSameTree(p.right, q.right)
                )
        return False
