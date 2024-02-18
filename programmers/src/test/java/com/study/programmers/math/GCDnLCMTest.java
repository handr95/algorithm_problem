package com.study.programmers.math;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GCDnLCMTest {
    GCDnLCM gcDnLCM = new GCDnLCM();

    @Test
    void test1() {
        int n = 3;
        int m = 12;
        assertThat(gcDnLCM.gcdlcm(n, m))
                .containsExactly(3, 12);
    }

    @Test
    void test2() {
        int n = 2;
        int m = 5;
        assertThat(gcDnLCM.gcdlcm(n, m))
                .containsExactly(1, 10);
    }

}
