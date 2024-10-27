package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/?envType=daily-question&envId=2024-10-26
 */
public class HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458 {
    private static HashMap<Integer, Integer> nodeValToLevelMap;
    private static HashMap<Integer, Integer> nodeValToMaxHeightMap;
    private static HashMap<Integer, Integer> levelToMaxHeightMap; // max height of top 1 node by level
    private static HashMap<Integer, Integer> levelTo2ndMaxHeighMap; // max height of top 2 node by level

    public static class TreeNode {
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
        public static TreeNode buildTree(Integer[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }
            int index = 1;
            TreeNode root = new TreeNode(arr[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty() && index < arr.length) {
                TreeNode parentNode = queue.poll();
                if (arr[index] != null) {
                    TreeNode left = new TreeNode(arr[index]);
                    queue.add(left);
                    parentNode.left = left;
                }
                index += 1;
                if (index < arr.length && arr[index] != null) {
                    TreeNode right = new TreeNode(arr[index]);
                    queue.add(right);
                    parentNode.right = right;
                }
                index += 1;
            }
            return root;
        }
    }
    public static int setMaxHeight(
        TreeNode root,
        int height
    ) {
        nodeValToLevelMap.put(root.val, height);
        int maxHeight = height;
        if (root.left != null) {
            int maxLeft = setMaxHeight(root.left, height + 1);
            if (maxHeight < maxLeft) {
                maxHeight = maxLeft;
            }
        }
        if (root.right != null) {
            int maxRight = setMaxHeight(root.right, height + 1);
            if (maxHeight < maxRight) {
                maxHeight = maxRight;
            }
        }
        nodeValToMaxHeightMap.put(root.val, maxHeight);
        int oldMaxHeigh = levelToMaxHeightMap.getOrDefault(height, 0);
        if (maxHeight > oldMaxHeigh) {
            levelTo2ndMaxHeighMap.put(height, oldMaxHeigh);
            levelToMaxHeightMap.put(height, maxHeight);
        } else if (maxHeight > levelTo2ndMaxHeighMap.getOrDefault(height, 0)) {
            levelTo2ndMaxHeighMap.put(height, maxHeight);
        }
        return maxHeight;
    }
    public static int[] treeQueries(TreeNode root, int[] queries) {
        int[] res = new int[queries.length];
        nodeValToLevelMap = new HashMap<>();
        nodeValToMaxHeightMap = new HashMap<>();
        levelToMaxHeightMap = new HashMap<>();
        levelTo2ndMaxHeighMap = new HashMap<>();

        setMaxHeight(root,0);
        int nodeVal, level, maxHeightOfNode, finalMaxHeight;
        for (int i = 0; i < queries.length; i++) {
            nodeVal = queries[i];
            level = nodeValToLevelMap.getOrDefault(nodeVal, 0);
            maxHeightOfNode = nodeValToMaxHeightMap.getOrDefault(nodeVal, 0);
            finalMaxHeight = levelToMaxHeightMap.getOrDefault(level, 0);
            if (finalMaxHeight == maxHeightOfNode) {
                finalMaxHeight = levelTo2ndMaxHeighMap.getOrDefault(level,0);
            }
            res[i] = Math.max(finalMaxHeight, level -1);
        }
        return res;
    }
    public static void main(String[] args) {
        // Test case 1
        Integer[] arr1 = {1,3,4,2,null,6,5,null,null,null,null,null,7};
        TreeNode root1 = TreeNode.buildTree(arr1);
        int[] queries1 = {4};
        int[] res1 = treeQueries(root1, queries1);
        System.out.println(Arrays.toString(res1)); // Output: [2]

        // Test case 2
        Integer[] arr2 = {5,8,9,2,1,3,7,4,6};
        TreeNode root2 = TreeNode.buildTree(arr2);
        int[] queries2 = {3, 2, 4, 8};
        int[] res2 = treeQueries(root2, queries2);
        System.out.println(Arrays.toString(res2)); // Output: [3,2,3,2]

        // Test case 3
        Integer[] arr3 = {8,6,37,3,7,33,65,1,4,null,null,29,36,51,66,null,2,null,5,26,31,35,null,45,58,null,null,null,null,null,null,22,28,30,32,34,null,44,47,55,59,21,25,27,null,null,null,null,null,null,null,41,null,46,48,54,56,null,62,13,null,24,null,null,null,38,42,null,null,null,49,53,null,null,57,60,64,11,20,23,null,null,39,null,43,null,50,52,null,null,null,null,61,63,null,10,12,18,null,null,null,null,40,null,null,null,null,null,null,null,null,null,null,9,null,null,null,16,19,null,null,null,null,15,17,null,null,14};
        TreeNode root3 = TreeNode.buildTree(arr3);
        int[] queries3= {22};
        int[] res3 = treeQueries(root3, queries3);
        System.out.println(Arrays.toString(res3)); // Output: [9]
    }
}

