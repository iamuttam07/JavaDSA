/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.8284, and since we need to return the floor of the square root (integer),
hence we returned 2.

Example 2:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2.
 */

class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 2, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long num = (long) mid * mid;
            if (num > x) right = mid - 1;
            else if (num < x) left = mid + 1;
            else return mid;
        }
        return right;
    }
}
