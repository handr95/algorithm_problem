package com.study.leetcode.twopiont;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/description
 * Medium
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * <p>
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {

    // Testcases passed, but took too long.
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int firstIdx = 0; firstIdx < nums.length - 2; firstIdx++) {
            if (nums[firstIdx] > 0) {
                return result;
            }
            if (firstIdx != 0 && nums[firstIdx - 1] == nums[firstIdx]) {
                continue;
            }
            int goal = -nums[firstIdx];
            for (int secondIdx = firstIdx + 1; secondIdx < nums.length - 1; secondIdx++) {
                if (secondIdx != firstIdx + 1 && nums[secondIdx - 1] == nums[secondIdx]) {
                    continue;
                }
                if (nums[firstIdx] + nums[secondIdx] > 0) {
                    break;
                }
                for (int thirdIdx = secondIdx + 1; thirdIdx < nums.length; thirdIdx++) {
                    int sum = nums[secondIdx] + nums[thirdIdx];
                    if (sum == goal) {
                        result.add(Arrays.asList(nums[firstIdx], nums[secondIdx], nums[thirdIdx]));
                        break;
                    } else if(sum > goal) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int firstIdx = 0; firstIdx < nums.length - 2; firstIdx++) {
            if (nums[firstIdx] > 0) {
                return result;
            }
            if (firstIdx != 0 && nums[firstIdx - 1] == nums[firstIdx]) {
                continue;
            }
            int goal = -nums[firstIdx];
            int start = firstIdx + 1;
            int finish = nums.length - 1;
            while(finish > start) {
                int sum = nums[start] + nums[finish];
                if (sum < goal ) {
                    start ++;
                } else  if (sum > goal) {
                    finish --;
                } else {
                    result.add(Arrays.asList(nums[firstIdx], nums[start], nums[finish]));
                    start ++;
                    finish --;
                    // 이전 요소와 동일하다면 건너뜀
                    while (finish > start && nums[start] == nums[start - 1]) start++;
                    while (finish > start && nums[finish] == nums[finish + 1]) finish--;
                }
            }

        }
        return result;
    }
}
