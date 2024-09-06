package com.study.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobberTest {
    HouseRobber houseRobber = new HouseRobber();

    @Test
    void test1() {
        int[] nums = {1,2,3,1};
        assertThat(houseRobber.rob(nums)).isEqualTo(4);
    }

    @Test
    void test2() {
        int[] nums = {2,7,9,3,1};
        assertThat(houseRobber.rob(nums)).isEqualTo(12);
    }
}
