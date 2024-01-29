package com.study.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TwoSumTest {
    TwoSum twoSum = new TwoSum();

    @Test
    void usingArray_test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        assertThat(result).containsExactly(0,1);
    }

    @Test
    void usingArray_test2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);
        assertThat(result).containsExactly(1,2);
    }

    @Test
    void usingArray_test3() {
        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);
        assertThat(result).containsExactly(0,1);
    }

    @Test
    void usingHashTable_test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSumUsingHashTable(nums, target);
        assertThat(result).containsExactly(0,1);
    }

    @Test
    void usingHashTable_test2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum.twoSumUsingHashTable(nums, target);
        assertThat(result).containsExactly(1,2);
    }

    @Test
    void usingHashTable_test3() {
        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum.twoSumUsingHashTable(nums, target);
        assertThat(result).containsExactly(0,1);
    }
}