package com.study.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {

    /**
     * 배열을 활용한 방식
     *  - 시간 복잡도 0(n^2)
     * @param nums 주어진 배열
     * @param target 두 쌍의 합
     * @return 목료 값이 되는 되는 배열 인덱스 두쌍
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 해시 테이블을 활용한 방식
     *  - 시간 복잡도 0(n)
     * @param nums 주어진 배열
     * @param target 두 쌍의 합
     * @return 목료 값이 되는 되는 배열 인덱스 두쌍
     */
    public int[] twoSumUsingHashTable(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> numRemainMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int remain = target - nums[i];
            if (numRemainMap.containsKey(remain)) {
                return new int[]{numRemainMap.get(remain), i};
            }
            numRemainMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }
}