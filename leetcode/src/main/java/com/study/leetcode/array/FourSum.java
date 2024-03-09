package com.study.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * Medium
 * https://leetcode.com/problems/4sum/description/
 *
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^ 9 <= target <= 10^9
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int firstIdx = 0; firstIdx < nums.length - 3; firstIdx++) {
            if (firstIdx != 0 && nums[firstIdx - 1] == nums[firstIdx]) {
                continue;
            }
            for (int secondIdx = firstIdx + 1; secondIdx < nums.length - 2; secondIdx++) {
                if (secondIdx != firstIdx + 1 && nums[secondIdx - 1] == nums[secondIdx]) {
                    continue;
                }
                for (int thirdIdx = secondIdx + 1; thirdIdx < nums.length - 1; thirdIdx++) {
                    if (thirdIdx != secondIdx + 1 && nums[thirdIdx - 1] == nums[thirdIdx]) {
                        continue;
                    }
                    for (int fourthIdx = nums.length - 1; fourthIdx >= thirdIdx + 1; fourthIdx--) {
                        long sum = (long)nums[firstIdx] + (long)nums[secondIdx] + (long)nums[fourthIdx] + (long)nums[thirdIdx];
                        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                            continue;
                        }
                        if (sum == target) {
                            result.add(Arrays.asList(nums[firstIdx],nums[secondIdx],nums[thirdIdx],nums[fourthIdx]));
                            break;
                        }
                        if (sum < target) {
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }


    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int firstIdx = 0; firstIdx < nums.length - 3; firstIdx++) {
            if (firstIdx != 0 && nums[firstIdx - 1] == nums[firstIdx]) {
                continue;
            }
            for (int secondIdx = firstIdx + 1; secondIdx < nums.length - 2; secondIdx++) {
                if (secondIdx != firstIdx + 1 && nums[secondIdx - 1] == nums[secondIdx]) {
                    continue;
                }

                int thirdIdx = secondIdx + 1;
                int fourthIdx = nums.length - 1;
                while (thirdIdx < fourthIdx) {
                    if (thirdIdx != secondIdx + 1 && nums[thirdIdx - 1] == nums[thirdIdx]) {
                        thirdIdx++;
                        continue;
                    }

                    long sum = (long)nums[firstIdx] + (long)nums[secondIdx] + (long)nums[thirdIdx] + (long)nums[fourthIdx];

                    if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                        fourthIdx--;
                    } else if (sum == target) {
                        result.add(Arrays.asList(nums[firstIdx], nums[secondIdx], nums[thirdIdx], nums[fourthIdx]));
                        thirdIdx++;
                    } else if (sum < target) {
                        thirdIdx++;
                    } else {
                        fourthIdx--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> solution(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> sum = new ArrayList<>();
        for(int i=0; i< nums.length -3; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            long target1 = (long)target-nums[i];
            for(int j=i+1; j< nums.length-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                long target2 = target1 -nums[j];
                int k= j+1;
                int l= nums.length - 1;
                while(k<l){
                    long rem = target2- nums[k];
                    if(nums[l]>rem){
                        l--;
                    }
                    else if( nums[l]<rem){
                        k++;
                    }
                    else{
                        sum.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k<l && nums[k]==nums[k+1]){
                            k++;
                        }
                        while(k<l && nums[l] == nums[l-1]){
                            l--;
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return sum;
    }
}
