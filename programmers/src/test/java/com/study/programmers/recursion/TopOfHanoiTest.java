package com.study.programmers.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TopOfHanoiTest {

    TopOfHanoi topOfHanoi = new TopOfHanoi();
    @Test
    void test1() {
        int n = 2;
        assertThat(topOfHanoi.topOfHanoi(n))
                .isEqualTo(new int[][] {{1,2}, {1,3}, {2,3}});
    }
}
