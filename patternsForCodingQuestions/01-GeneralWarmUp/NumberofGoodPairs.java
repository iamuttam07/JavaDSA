/*
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs, here are the indices: (0,3), (0,4), (3,4), (2,5).

Example 2:
Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array is a 'good pair'.
 */

import java.util.HashMap;

class NumberofGoodPairs {
    public int numGoodPairs(int[] nums) {
        int pairCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            pairCount += map.get(num) - 1;
        }
        return pairCount;
    }
}
