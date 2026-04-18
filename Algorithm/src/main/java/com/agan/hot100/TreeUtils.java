package com.agan.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

    public static TreeNode buildTree(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        build(arr, root, 0);
        return root;
    }

    public static void build(int[] arr, TreeNode root, int index) {
        if (root == null) return;
        int leftIndex = 2 * index + 1;
        if ((leftIndex) < arr.length) {
            TreeNode left;
            if (arr[leftIndex] == -1) {
                left = null;
            } else {
                left = new TreeNode(arr[leftIndex]);
            }
            root.left = left;
            build(arr, root.left, leftIndex);
        }
        int rightIndex = 2 * index + 2;
        if (rightIndex < arr.length) {
            TreeNode right;
            if (arr[rightIndex] == -1) {
                right = null;
            } else {
                right = new TreeNode(arr[rightIndex]);
            }
            root.right = right;
            build(arr, root.right, rightIndex);
        }
    }

    /** 从 LeetCode 题面层序数组（含 null）构建二叉树，例如 {@code [10,5,-3,3,2,null,11,...]}。 */
    public static TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < levelOrder.length) {
            TreeNode cur = q.poll();

            if (i < levelOrder.length) {
                Integer leftVal = levelOrder[i++];
                if (leftVal != null) {
                    cur.left = new TreeNode(leftVal);
                    q.offer(cur.left);
                } else {
                    cur.left = null;
                }
            }
            if (i < levelOrder.length) {
                Integer rightVal = levelOrder[i++];
                if (rightVal != null) {
                    cur.right = new TreeNode(rightVal);
                    q.offer(cur.right);
                } else {
                    cur.right = null;
                }
            }
        }
        return root;
    }

    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    /** 力扣层序字符串，如 {@code [3,9,20,null,null,15,7]}；队列用 {@link LinkedList} 以便入队 null。 */
    public static String toLevelOrderLeetCode(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<String> parts = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) {
                parts.add("null");
            } else {
                parts.add(String.valueOf(n.val));
                q.offer(n.left);
                q.offer(n.right);
            }
        }
        while (!parts.isEmpty() && "null".equals(parts.get(parts.size() - 1))) {
            parts.remove(parts.size() - 1);
        }
        return "[" + String.join(",", parts) + "]";
    }

    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
