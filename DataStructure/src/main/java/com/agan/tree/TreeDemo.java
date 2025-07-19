package com.agan.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 树
 *      1
 *    2   3
 *   4 5
 */
public class TreeDemo {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2, root);
        Node node3 = new Node(3, root);
        Node node4 = new Node(4, node2);
        Node node5 = new Node(5, node2);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
//        testPreorderTraversal(root);
//        testPreorderTraversalStack(root);
//        testMiddleTraversal(root);
//        testMiddleTraversalStack(root);
        testPostTraversalStack(root);
    }

    /**
     * 前序遍历  递归实现
     */
    static void testPreorderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.value);
            if (root.left != null) {
                testPreorderTraversal(root.left);
            }
            if (root.right != null) {
                testPreorderTraversal(root.right);
            }
        }
    }

    /**
     * 前序遍历  栈实现
     */
    static void testPreorderTraversalStack(Node tree) {
        Stack<Node> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                System.out.println(tree.value);
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                tree = tree.right;
            }
        }
    }

    /**
     * 中遍历  递归实现
     */
    static void testMiddleTraversal(Node root) {
        if (root.left != null) {
            testMiddleTraversal(root.left);
        }
        System.out.println(root.value);
        if (root.right != null) {
            testMiddleTraversal(root.right);
        }
    }

    /**
     * 中序遍历 栈实现 左->中->右
     * @param tree
     */
    static void testMiddleTraversalStack(Node tree) {
        Stack<Node> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (stack != null) {
                tree = stack.pop();
                System.out.println(tree.value);
                tree = tree.right;
            }
        }
    }

    /**
     * 后序遍历 栈实现 左->右->中
     */
    static void testPostTraversalStack(Node tree) {
        List<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            tree = stack.pop();
            if (tree.left != null) {
                stack.push(tree.left);
            }
            if (tree.right != null) {
                stack.push(tree.right);
            }
            result.add(0, tree.value);
        }
        System.out.println(result);
    }
}

