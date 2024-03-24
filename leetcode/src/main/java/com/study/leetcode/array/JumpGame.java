package com.study.leetcode.array;

/**
 * 55. Jump Game
 * Medium
 * https://leetcode.com/problems/jump-game/description/
 *
 * You are given an integer array nums.
 * You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int moveIdx = nums.length - 1;
        // 도착 지점으로 부터 시작.
        int goal = nums.length - 1; // 목표 지점
        int distance = 0;   // goal까지의 거리
        while (moveIdx > 0) {
            moveIdx --;
            distance++;
            int step = nums[moveIdx];
            // 목표지점까지 도달할수 있는지 확인.
            if (step >= distance) {
                distance = 0;
                goal = moveIdx;
            }
        }
        return goal == 0;
    }
}
