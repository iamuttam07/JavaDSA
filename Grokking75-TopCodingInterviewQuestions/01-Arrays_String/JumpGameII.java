/*
You are given an array nums containing n integers, where nums[i] represents the maximum length of a forward jump you
can make from index i. You are initially positioned at nums[0].
Return the minimum number of jumps needed to reach from the start to the end of the array.

Example 1:
Input: nums = [2, 3, 2, 2, 1]
Expected Output: 2
Justification: Start at index 0 and jump to index 1 (jump size 1). Then, jump from index 1 to the end (jump size 3).

Example 2:
Input: nums = [1, 2, 3, 4, 5]
Expected Output: 3
Justification: Start at index 0, jump to index 1 (jump size 1). Then, jump to index 3 (jump size 2). Finally, jump to
the end (jump size 2).
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int jump = 0, currEnd = 0, currFar = 0;
        for (int i = 0; i < nums.length; i++) {
            currFar = Math.max(currFar, nums[i] + i);
            if (i == currEnd) {
                jump++;
                currEnd = currFar;
                if (currEnd >= nums.length - 1) return jump;
            }
        }
        return jump;
    }
}
