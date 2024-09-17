/*
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of
three different numbers that is why it is called Dutch National Flag problem.

Example 1:

Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]
Example 2:

Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]
 */

class DutchNationalFlag {
    public int[] sort(int[] arr) {
        int low = 0; //count 0's
        int i = 0; //count 1's
        int high = arr.length - 1; //count 2's

        while (i <= high) {
            if (arr[i] == 0) {
                swap(low, i, arr);
                low++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(i, high, arr);
                high--;
            }
        }
        return arr;
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
