#
# https://leetcode.com/problems/average-of-levels-in-binary-tree/
#

# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        result: List[float] = []
        bfs: list[TreeNode] = []
        bfs.append(root)
        while True:
            children = []
            sum = 0
            for node in bfs:
                sum += node.val
                if node.left:
                    children.append(node.left)
                if node.right:
                    children.append(node.right)
            avg = int(sum / len(bfs) * 100_000) / 100_000
            result.append(avg)
            if children:
                bfs = children
            else:
                break

        return result
