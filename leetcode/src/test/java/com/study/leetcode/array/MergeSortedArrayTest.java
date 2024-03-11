package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortedArrayTest {
    MergeSortedArray mergeSortedArray = new MergeSortedArray();

    @Test
    void test01() {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        mergeSortedArray.mergeSortedArray(num1, 3, num2, 3);
        assertThat(num1).containsExactly(1,2,2,3,5,6);
    }

    @Test
    void test02() {
        int[] num1 = {1};
        int[] num2 = {};
        mergeSortedArray.mergeSortedArray(num1, 1, num2, 0);
        assertThat(num1).containsExactly(1);
    }

    @Test
    void test03() {
        int[] num1 = {0};
        int[] num2 = {1};
        mergeSortedArray.mergeSortedArray(num1, 0, num2, 1);
        assertThat(num1).containsExactly(1);
    }
}
