/*
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

Example 1:
Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted

Example 2:
Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 */
class MinimumWindowSort {
    public static int sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high && arr[low] <= arr[low + 1]) low++;
        if (low == arr.length - 1) return 0;
        while (high > 0 && arr[high] > arr[high - 1]) high--;
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int k = low; k <= high; k++) {
            subarrayMax = Math.max(subarrayMax, arr[k]);
            subarrayMin = Math.min(subarrayMin, arr[k]);
        }
        while (low > 0 && arr[low - 1] > subarrayMin) low--;
        while (high < arr.length - 1 && arr[high + 1] < subarrayMax) high++;
        return high - low + 1;
    }
}
