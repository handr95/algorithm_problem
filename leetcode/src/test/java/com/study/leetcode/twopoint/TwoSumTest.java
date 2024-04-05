package com.study.leetcode.twopoint;

import com.study.leetcode.twopiont.TwoSum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {
    TwoSum twoSum = new TwoSum();

    @Test
    void test1() {
        assertThat(twoSum.twoSum(new int[]{2,7,11,15}, 9))
                .containsExactly(1,2);
    }

    @Test
    void test2() {
        assertThat(twoSum.twoSum(new int[]{2,3,4}, 6))
                .containsExactly(1,3);
    }

    @Test
    void test3() {
        assertThat(twoSum.twoSum(new int[]{-1,0}, -1))
                .containsExactly(1,2);
    }
}
