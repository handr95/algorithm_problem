package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveElementTest {
    RemoveElement removeElement = new RemoveElement();
    @Test
    void test01() {
        int[] nums = {3,2,2,3};
        assertThat(removeElement.removeElement(nums, 3))
                .isEqualTo(2);
        assertThat(nums).contains(2,2);
    }

    @Test
    void test02() {
        int[] nums = {0,1,2,2,3,0,4,2};
        assertThat(removeElement.removeElement(nums, 2))
                .isEqualTo(5);
        assertThat(nums).contains(0,1,4,0,3);
    }
}
