package com.study.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PonkemonTest {
    Ponkemon ponkemon = new Ponkemon();

    @Test
    void test1() {
        int[] nums = {3,1,2,3};
        assertThat(ponkemon.ponkemon(nums)).isEqualTo(2);
    }

    @Test
    void test2() {
        int[] nums = {3,3,3,2,2,4};
        assertThat(ponkemon.ponkemon(nums)).isEqualTo(3);
    }

    @Test
    void test3() {
        int[] nums = {3,3,3,2,2,2};
        assertThat(ponkemon.ponkemon(nums)).isEqualTo(2);
    }

}
