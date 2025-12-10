/*
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * 
*/
package Blind75.Arrays;

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();

        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;

        int[] res = obj.topKFrequent(nums, k);

        System.out.println(Arrays.toString(res));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();
            bucket.get(freq).add(num);
        }

        int[] ans = new int[k];
        int idx = 0;

        for (int j = n; j >= 0 && idx < k; j--) {
            for (int num : bucket.get(j)) {
                ans[idx++] = num;
                if (idx >= k) break;
            }
        }

        return ans;
    }
}
