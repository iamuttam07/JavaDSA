/*
We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular
index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
You should assume that the array is circular which means two things:

If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one
direction which means the cycle should not contain both forward and backward movements.

Example 1:

Input: [1, 2, -1, 2, 2]
Output: true
Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
Example 2:

Input: [2, 2, -1, 2]
Output: true
Explanation: The array has a cycle among indices: 1 -> 3 -> 1
 */
class CycleInACircularArray {

    public boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0;
            int slow = i, fast = i;
            do {
                slow = findNextIndex(arr, isForward, slow);
                if (slow == -1) break;
                fast = findNextIndex(arr, isForward, fast);
                if (fast != -1) fast = findNextIndex(arr, isForward, fast);
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow == fast) return true;
        }
        return false;
    }

    public static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction) return -1;

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

        if (nextIndex < 0) nextIndex += arr.length;

        if (nextIndex == currentIndex) nextIndex = -1;

        return nextIndex;

    }
}
