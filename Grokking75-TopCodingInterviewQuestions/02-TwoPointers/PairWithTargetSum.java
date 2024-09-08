/*
Given an array of numbers sorted in ascending order and a target sum, find a pair in the array whose sum is equal to
thegiven target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
If no such pair exists return [-1, -1].

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
Example 2:

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */

class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {

        //Method 1: using HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(targetSum - arr[i])) {
                return new int[]{map.get(targetSum - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};

        //Method 2 :- Using Two Pointer
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int currSum = arr[start] + arr[end];
            if (currSum == targetSum) {
                return new int[]{start, end};
            } else if (currSum < targetSum) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};
    }
}
