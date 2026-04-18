package com.agan.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class $78_Subsets {

    List<List<Integer>> result = new ArrayList();
    LinkedList<Integer> path = new LinkedList();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    public void backTracking(int[] nums, int start) {
        result.add(new ArrayList(path));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i+1);
            path.removeLast();
        }
    }
}
