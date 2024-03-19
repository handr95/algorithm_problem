package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IncreasingTripletSubsequenceTest {
    IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();

    @Test
    void test01() {
        assertThat(increasingTripletSubsequence.increasingTriplet(new int[]{1,2,3,4,5})).isTrue();
    }

    @Test
    void test02() {
        assertThat(increasingTripletSubsequence.increasingTriplet(new int[]{5,4,3,2,1})).isFalse();
    }

    @Test
    void test03() {
        assertThat(increasingTripletSubsequence.increasingTriplet(new int[]{2,1,5,0,4,6})).isTrue();
    }

    @Test
    void test04() {
        assertThat(increasingTripletSubsequence.increasingTriplet(new int[]{20,100,10,12,5,13})).isTrue();
    }
}
