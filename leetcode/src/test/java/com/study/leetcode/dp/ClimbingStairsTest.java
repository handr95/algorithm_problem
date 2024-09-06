package com.study.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbingStairsTest {
    ClimbingStairs climbingStairs = new ClimbingStairs();

    @Test
    void test1() {
        assertThat(climbingStairs.climbStairs(2)).isEqualTo(2);
    }

    @Test
    void test2() {
        assertThat(climbingStairs.climbStairs(3)).isEqualTo(3);
    }
}
