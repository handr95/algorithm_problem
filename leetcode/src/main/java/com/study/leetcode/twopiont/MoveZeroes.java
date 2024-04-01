package com.study.leetcode.twopiont;

import java.util.ArrayList;
import java.util.List;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes
 * Easy
 *
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        List<Integer> noneZeroIdx = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                noneZeroIdx.add(nums[i]);
            }
        }

        int current = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i < noneZeroIdx.size()) {
                nums[i] = noneZeroIdx.get(current);
                current++;
            } else {
                nums[i] = 0;
            }
        }
    }
    public void solution(int[] nums) {
        int n = nums.length;
        int m = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] != 0){
                nums[m] = nums[i];
                m++;
            }
        }
        while(m<n){
            nums[m]=0;
            m++;
        }
    }
}
