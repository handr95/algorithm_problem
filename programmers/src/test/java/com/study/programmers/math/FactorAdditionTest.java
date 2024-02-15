package com.study.programmers.math;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactorAdditionTest {
    FactorAddition factorAddition = new FactorAddition();

    @Test
    void test1() {
        int left = 13;
        int right = 17;
        assertThat(factorAddition.solution(left, right))
                .isEqualTo(43);
    }

    @Test
    void test2() {
        int left = 24;
        int right = 27;
        assertThat(factorAddition.solution(left, right))
                .isEqualTo(52);
    }
}
