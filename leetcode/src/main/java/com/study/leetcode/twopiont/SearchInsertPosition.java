package com.study.leetcode.twopiont;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 * Easy
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int startIdx = 0;
        int endIdx = nums.length - 1;
        while (startIdx <= endIdx) {
            int mid = startIdx + (endIdx - startIdx) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                endIdx = mid - 1;
            } else {
                startIdx = mid + 1;
            }
        }

        return startIdx;
    }
}
