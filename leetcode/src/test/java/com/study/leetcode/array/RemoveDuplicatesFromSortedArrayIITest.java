package com.study.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesFromSortedArrayIITest {
    RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();

    @Test
    void test01() {
        int[] nums = {1,1,1,2,2,3};
        Assertions.assertThat(removeDuplicatesFromSortedArrayII.removeDuplicates(nums))
                .isEqualTo(5);

        assertThat(nums).startsWith(1,1,2,2,3);
    }

    @Test
    void test02() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        Assertions.assertThat(removeDuplicatesFromSortedArrayII.removeDuplicates(nums))
                .isEqualTo(7);

        assertThat(nums).startsWith(0,0,1,1,2,3,3);
    }
}
