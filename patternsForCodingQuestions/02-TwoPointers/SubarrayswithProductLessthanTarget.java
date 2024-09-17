import java.util.*;

/*
Given an array with positive numbers and a positive target number, find all of its contiguous subarrays whose product
is less than the target number.

Example 1:
Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.

Example 2:
Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.
 */
class SubarrayswithProductLessthanTarget {

    public List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left <= right) {
                product /= arr[left++];
            }
            List<Integer> tempList = new ArrayList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList(tempList));
            }
        }
        return result;
    }
}
