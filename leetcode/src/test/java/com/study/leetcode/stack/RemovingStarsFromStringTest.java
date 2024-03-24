package com.study.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemovingStarsFromStringTest {
    RemovingStarsFromString removingStarsFromString = new RemovingStarsFromString();

    @Test
    void test1() {
        assertThat(removingStarsFromString.removingStarsFromString("leet**cod*e"))
                .isEqualTo("lecoe");
    }

    @Test
    void test2() {
        assertThat(removingStarsFromString.removingStarsFromString("erase*****"))
                .isEmpty();
    }
}
