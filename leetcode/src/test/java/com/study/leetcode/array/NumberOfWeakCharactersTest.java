package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfWeakCharactersTest {
    NumberOfWeakCharacters numberOfWeakCharacters = new NumberOfWeakCharacters();

    @Test
    void test1() {
        int[][] properties = {{5,5},{6,3},{3,6}};
        assertThat(numberOfWeakCharacters.numberOfWeakCharacters(properties))
                .isZero();
    }

    @Test
    void test2() {
        int[][] properties = {{2,2},{3,3}};
        assertThat(numberOfWeakCharacters.numberOfWeakCharacters(properties))
                .isEqualTo(1);
    }

    @Test
    void test3() {
        int[][] properties = {{1,5},{10,4},{4,3}};
        assertThat(numberOfWeakCharacters.numberOfWeakCharacters(properties))
                .isEqualTo(1);
    }
}
