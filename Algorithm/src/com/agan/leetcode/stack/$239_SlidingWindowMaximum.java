package com.agan.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        TopQueue topQueue = new TopQueue();
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            topQueue.add(nums[i]);
        }
        int index = 0;
        int[] res = new int[n - k + 1];
        res[index++] = topQueue.peek();
        for (int i = k; i < n; i++) {
            topQueue.poll(nums[i-k]);
            topQueue.add(nums[i]);
            res[index++] = topQueue.peek();
        }
        return res;
    }

    public static class TopQueue {
        //Deque是java的双端队列。Java官方推荐放弃使用栈Stack，使用Deque
        Deque<Integer> q = new LinkedList<>();
        //这里如果是包装类，就不要用等于号了
        public void poll(int value) {
            if (!q.isEmpty() && q.peek() == value) {
                q.poll();
            }
        }

        public void add(Integer item) {
            while (!q.isEmpty() && q.getLast() < item) {
                q.removeLast();
            }
            q.add(item);
        }

        public Integer peek() {
            return q.peek();
        }
    }
}
