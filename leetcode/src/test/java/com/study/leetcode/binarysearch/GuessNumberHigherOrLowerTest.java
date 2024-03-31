package com.study.leetcode.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GuessNumberHigherOrLowerTest {
    GuessNumberHigherOrLower guessNumberHigherOrLower = new GuessNumberHigherOrLower();

    @Test
    void test1(){
        guessNumberHigherOrLower.setPick(6);
        assertThat(guessNumberHigherOrLower.guessNumber(10))
                .isEqualTo(6);
    }
    @Test
    void test2(){
        guessNumberHigherOrLower.setPick(1);
        assertThat(guessNumberHigherOrLower.guessNumber(1))
                .isEqualTo(1);
    }

    @Test
    void test3(){
        guessNumberHigherOrLower.setPick(1);
        assertThat(guessNumberHigherOrLower.guessNumber(2))
                .isEqualTo(1);
    }

    @Test
    void test4(){
        guessNumberHigherOrLower.setPick(4);
        assertThat(guessNumberHigherOrLower.guessNumber(30))
                .isEqualTo(4);
    }
}
