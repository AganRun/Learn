package com.agan.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 32. 重新安排行程
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 *
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 *
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 *
 *输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * 输出：["JFK","MUC","LHR","SFO","SJC"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $332_ReconstructItinerary {

    LinkedList<String> result = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        boolean[] used = new boolean[tickets.size()];
        //从小到大排列。注意，比较的是目的地，不是始发地。要从小到到排列
        Collections.sort(tickets, (a,b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        backtracking(tickets, used);
        return result;
    }

    public boolean backtracking(List<List<String>> tickets, boolean[] used) {
        if (path.size() == tickets.size() + 1) {
            result = new LinkedList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            //当前票的开始站，刚好是上一张票的结束站
            if (used[i] || !tickets.get(i).get(0).equals(path.getLast())) {
                continue;
            }
            used[i] = true;
            path.add(tickets.get(i).get(1));
            //如果找到了目标值，就返回，以免超时
            if (backtracking(tickets, used)) {
                return true;
            }
            used[i] = false;
            path.removeLast();
        }
        return false;
    }

    public static void main(String[] args) {
        $332_ReconstructItinerary r = new $332_ReconstructItinerary();
        List<List<String>> tickets = Stream.of(Stream.of("MUC","LHR").collect(Collectors.toList()),
        Stream.of("JFK","MUC").collect(Collectors.toList()),
        Stream.of("SFO","SJC").collect(Collectors.toList()),
        Stream.of("LHR","SFO").collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(r.findItinerary(tickets));
    }
}
