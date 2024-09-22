/*
Any number will be called a happy number if, after repeatedly replacing it with a number equal to the
sum of the square of all of its digits, leads us to the number 1. All other (not-happy) numbers will never reach 1.
Instead, they will be stuck in a cycle of numbers that does not include 1.

Given a positive number n, return true if it is a happy number otherwise return false.
Example 1:
Input: 23
Output: true (23 is a happy number)

Example 2:
Input: 12
Output: false (12 is not a happy number)
Please note the cycle from 89 -> 89.
 */
class HappyNumber {

    public boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);
        if (slow == 1) return true;
        return false;
    }

    public int findSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int digit = num % 10;
            ans += digit * digit;
            num /= 10;
        }
        return ans;
    }
}
