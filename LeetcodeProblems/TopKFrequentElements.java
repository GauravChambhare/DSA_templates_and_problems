/*
[https://neetcode.io/problems/top-k-elements-in-list/question?list=blind75](https://neetcode.io/problems/top-k-elements-in-list/question?list=blind75)
[https://leetcode.com/problems/top-k-frequent-elements/description/?envType=problem-list-v2&envId=oizxjoit](https://leetcode.com/problems/top-k-frequent-elements/description/?envType=problem-list-v2&envId=oizxjoit)
Top K Frequent Elements 
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]
*/
package LeetcodeProblems;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min-heap on frequency
        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(freq.get(a), freq.get(b)));

        for (Integer num : freq.keySet()) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }

        Integer[] tmp = pq.toArray(new Integer[0]);  // this returns Integer[]
        int[] ans = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            ans[i] = tmp[i];                         // unbox
        }

        return ans;
    }

    // Simple local test
    public static void main(String[] args) {
        TopKFrequentElements solver = new TopKFrequentElements();

        int[] nums1 = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(solver.topKFrequent(nums1, 2))); // expect [1,2] in any order

        int[] nums2 = {1};
        System.out.println(Arrays.toString(solver.topKFrequent(nums2, 1))); // expect [1]

        int[] nums3 = {1,2,1,2,1,2,3,1,3,2};
        System.out.println(Arrays.toString(solver.topKFrequent(nums3, 2))); // expect [1,2] in any order
    }
}
