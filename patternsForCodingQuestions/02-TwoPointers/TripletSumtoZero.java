import java.util.*;
/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
Explanation: There are four unique triplets whose sum is equal to zero. smallest sum.'

Example 2:
Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.
 */

class TripletSumtoZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            findPair(i, arr, triplets);
        }
        return triplets;
    }

    private static void findPair(int i, int[] arr, List<List<Integer>> triplets) {
        int target = -arr[i];
        i = i + 1;
        int j = arr.length - 1;
        while (i < j) {
            int currentSum = arr[i] + arr[j];
            if (currentSum < target) i++;
            else if (currentSum > target) j--;
            else {
                triplets.add(Arrays.asList(-target, arr[i], arr[j]));
                i++;
                j--;
                while (i < j && arr[i] == arr[i - 1]) i++;
                while (i < j && arr[j] == arr[j + 1]) j--;
            }
        }
    }
}
