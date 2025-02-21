package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

// Definition for singly-linked list.

public class BinaryTreePaths_257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void getAllRootToLeaf(TreeNode root, StringBuffer currTree, List<String> result) {
        int old_size = currTree.length();
        if (root.left == null && root.right == null) {
            result.add(currTree.toString());
        }
        if (root.left != null) {
            currTree.append("->").append(root.left.val);
            getAllRootToLeaf(root.left, currTree, result);
            currTree.setLength(old_size);
        }
        if (root.right != null) {
            currTree.append("->").append(root.right.val);
            getAllRootToLeaf(root.right, currTree, result);
            currTree.setLength(old_size);
        }
    } 
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            StringBuffer currTree = new StringBuffer();
            currTree.append(root.val);
            getAllRootToLeaf(root, currTree, res);
        }
        return res;
    }
}
