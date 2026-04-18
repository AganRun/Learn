package com.agan.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] edge = new ArrayList[numCourses];
        int learned = 0;
        int[] degree = new int[numCourses];
        for(int[] pre : prerequisites) {
            int source = pre[0];
            int target = pre[1];
            degree[target]++;
            List<Integer> postList = edge[source];
            if (postList == null) {
                postList = new ArrayList();
            }
            postList.add(target);
            edge[source] = postList;
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int item = queue.poll();
            learned++;
            List<Integer> post = edge[item];
            if (post != null && !post.isEmpty()) {
                for(int i = 0; i < post.size(); i++) {
                    if (--degree[post.get(i)] == 0) {
                        queue.offer(post.get(i));
                    }
                }
            }
        }
        return learned == numCourses;
    }

    public static void main(String[] args) {
        $207_CourseSchedule c = new $207_CourseSchedule();
        int[][] pre = {{1,0},{2,0}};
        System.out.println(c.canFinish(3,pre));
    }
}
