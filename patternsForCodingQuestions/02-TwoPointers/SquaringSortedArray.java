/*
Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

Example 1:
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Example 2:
Input: [-3, -1, 0, 1, 2]
Output: [0, 1, 1, 4, 9]
 */
class SquaringSortedArray {
    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int i = 0, j = arr.length - 1, k = j;
        while (i <= j) {
            int leftSquare = arr[i] * arr[i];
            int rightSquare = arr[j] * arr[j];
            if (leftSquare > rightSquare) {
                squares[k--] = leftSquare;
                i++;
            } else {
                squares[k--] = rightSquare;
                j--;
            }
        }
        return squares;
    }
}
