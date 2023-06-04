package com.agan.leetcode.list;

public class ListNodeSingle {

    private int val;

    private ListNodeSingle next;

    public ListNodeSingle(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + "->" + next;
        }
        return String.valueOf(val);
    }

    public static void main(String[] args) {
        ListNodeSingle f = new ListNodeSingle(1);
        ListNodeSingle s = new ListNodeSingle(2);
        f.next = s;
        System.out.println(f);
    }
}
