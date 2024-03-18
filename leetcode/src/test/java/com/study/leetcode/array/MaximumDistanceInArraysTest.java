package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDistanceInArraysTest {
    MaximumDistanceInArrays maximumDistanceInArrays = new MaximumDistanceInArrays();

    @Test
    void test1() {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1,2,3));
        arrays.add(Arrays.asList(4,5));
        arrays.add(Arrays.asList(1,2,3));

        assertThat(maximumDistanceInArrays.maxDistance(arrays)).isEqualTo(4);
    }

    @Test
    void test2() {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(List.of(1));
        arrays.add(List.of(1));

        assertThat(maximumDistanceInArrays.maxDistance(arrays)).isZero();
    }
}
