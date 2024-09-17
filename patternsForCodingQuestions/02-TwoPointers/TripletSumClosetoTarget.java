import java.util.*;

/*
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the
target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of
the triplet with the smallest sum.

Example 1:
Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: The triplet [-1, 0, 3] has the sum '2' which is closest to the target.
There are two triplets with distance '1' from the target: [-1, 0, 3] & [-1, 2, 3]. Between these two triplets,
the correct answer will be [-1, 0, 3] as it has a sum '2' which is less than the sum of the other triplet which is '4'.
This is because of the following requirement: 'If there are more than one such triplet, return the sum of the triplet
with the smallest sum.'

Example 2:
Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 */
import java.util.*;

class TripletSumClosetoTarget {

    public int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                int targetDiff = Math.abs(targetSum - sum);
                if (targetDiff == 0) return targetSum;
                if (sum < targetSum) left++;
                else right--;
                if (targetDiff < smallestDifference || (targetDiff == smallestDifference && sum < ans)) {
                    smallestDifference = targetDiff;
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
