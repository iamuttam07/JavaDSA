/*
You are given an array of integers nums. You start at the first index of the array and each element in nums represents
the maximum number of steps you can jump forward from that position.

Return true if you can reach the last index, or false otherwise.

Example 1
Input: nums = [1, 2, 3, 4, 5]
Expected Output: true
Justification: Starting at index 0, you can jump 1 step to index 1. From index 1, you can jump 2 steps to index 3. From
index 3, you can jump 1 steps to the last index (4). Therefore, it is possible to reach the end.

Example 2
Input: nums = [2, 0, 2, 0, 1]
Expected Output: true
Justification: Starting at index 0, you can jump 2 steps to index 2. From index 2, you can jump 2 steps to the last
index (4). Therefore, it is possible to reach the end.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= maxReach) maxReach = i;
        }
        return maxReach == 0;
    }
}
