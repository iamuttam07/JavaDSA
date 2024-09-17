import java.util.*;
/*
Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
whose sum is equal to the target number.

Example 1:
Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.

Example 2:
Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.
 */

class QuadrupleSumToTarget {

    public List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                findPairs(arr, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    public void findPairs(int[] arr, int target, int first, int second, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if (sum == target) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++;
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            } else if (sum < target) {
                left++;
            } else
                right--;
        }
    }
}
