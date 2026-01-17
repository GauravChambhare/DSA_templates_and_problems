/*
https://neetcode.io/problems/minimum-cost-to-connect-sticks/question?list=allNC
on leetcode it exists but a premium problem
You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the iᵗʰ stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.


*/
package LeetcodeProblems;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    // LeetCode / NeetCode method
    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length <= 1) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.offer(stick);
        }

        int ans = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int c = a + b;
            pq.offer(c);
            ans += c;
        }
        return ans;
    }

    // Local runner
    public static void main(String[] args) {
        MinimumCostToConnectSticks solver = new MinimumCostToConnectSticks();

        int[] sticks1 = {2, 4, 3};
        int[] sticks2 = {1, 8, 3, 5};
        int[] sticks3 = {5};

        System.out.println("Example 1: " + solver.connectSticks(sticks1)); // 14
        System.out.println("Example 2: " + solver.connectSticks(sticks2)); // 30
        System.out.println("Example 3: " + solver.connectSticks(sticks3)); // 0
    }
}
