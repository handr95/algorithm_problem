package com.study.leetcode.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfRecentCallsTest {
    NumberOfRecentCalls.RecentCounter recentCounter;

    @Test
    void test01() {
        recentCounter = new NumberOfRecentCalls.RecentCounter();
        assertThat(recentCounter.ping(1)).isEqualTo(1);
        assertThat(recentCounter.ping(100)).isEqualTo(2);
        assertThat(recentCounter.ping(3001)).isEqualTo(3);
        assertThat(recentCounter.ping(3002)).isEqualTo(3);
    }
}
