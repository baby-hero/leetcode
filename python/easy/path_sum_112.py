#
# https://leetcode.com/problems/path-sum/
#

# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def checkSum(
        self, root: Optional[TreeNode], sum_path: int, target: int
    ) -> bool:
        sum_path = sum_path + root.val
        if root.left is None and root.right is None:
            return sum_path == target

        if root.left:
            if self.checkSum(root.left, sum_path, target):
                return True

        if root.right:
            if self.checkSum(root.right, sum_path, target):
                return True
        return False

    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root is None:
            return False
        sum = 0
        return self.checkSum(root, sum, targetSum)


Solution().hasPathSum(TreeNode(-2, None, TreeNode(-1)), -5)
