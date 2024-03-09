package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FourSumTest {
    FourSum fourSum = new FourSum();

    @Test
    void test01() {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(-2,-1,1,2));
        expect.add(Arrays.asList(-2,0,0,2));
        expect.add(Arrays.asList(-1,0,0,1));
        assertThat(fourSum.fourSum2(nums, target)).isEqualTo(expect);
    }

    @Test
    void test02() {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(2,2,2,2));
        assertThat(fourSum.fourSum(nums, target)).isEqualTo(expect);
    }
}