package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicateFromSortedArrayTest {
    RemoveDuplicateFromSortedArray removeDuplicateFromSortedArray = new RemoveDuplicateFromSortedArray();

    @Test
    void test1() {
        int[] nums = {1,1,2};
        assertThat(removeDuplicateFromSortedArray.removeDuplicates(nums)).isEqualTo(2);
        assertThat(nums).containsExactly(1,2,0);
    }
    @Test
    void test2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        assertThat(removeDuplicateFromSortedArray.removeDuplicates(nums)).isEqualTo(5);
        assertThat(nums).containsExactly(0,1,2,3,4,0,0,0,0,0);
    }
}
