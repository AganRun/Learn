package com.agan.tree;

class Node {

    Integer value;
    Node parent;
    Node left;
    Node right;

    public Node(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node(Integer value, Node parent) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
}
