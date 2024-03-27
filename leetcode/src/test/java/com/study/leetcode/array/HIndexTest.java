package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HIndexTest {
    HIndex hIndex = new HIndex();

    @Test
    void test1() {
        assertThat(hIndex.hIndex2(new int[]{3,0,6,1,5}))
                .isEqualTo(3);
    }

    @Test
    void test2() {
        assertThat(hIndex.hIndex2(new int[]{1,3,1}))
                .isEqualTo(1);
    }

    @Test
    void test3() {
        assertThat(hIndex.hIndex2(new int[]{0, 10}))
                .isEqualTo(1);
    }

    @Test
    void test4() {
        assertThat(hIndex.hIndex2(new int[]{0}))
                .isEqualTo(0);
    }
}
