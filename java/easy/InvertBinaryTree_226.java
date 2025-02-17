package easy;

import hard.HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458.TreeNode;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */

public class InvertBinaryTree_226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = null;
            TreeNode right = null;
            if (root.left != null) {
                left = root.left;
            }
            if (root.right != null) {
                right = root.right;
            };
            root.left = right;
            root.right = left;
            invertTree(left);
            invertTree(right);
        }
        return root;
    }
}
