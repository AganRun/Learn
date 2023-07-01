package com.agan.leetcode.tree;

public class TreeUtils {

    public static TreeNode buildTree(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        build(arr, root, 0);
        return root;
    }

    public static void build(int[] arr, TreeNode root, int index) {
        int leftIndex = 2 * index + 1;
        if ((leftIndex) < arr.length) {
            TreeNode left = new TreeNode(arr[leftIndex]);
            root.left = left;
            build(arr, root.left, leftIndex);
        }
        int rightIndex = 2 * index + 2;
        if (rightIndex < arr.length) {
            TreeNode right = new TreeNode(arr[rightIndex]);
            root.right = right;
            build(arr, root.right, rightIndex);
        }
    }
}
