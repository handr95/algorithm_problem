package com.study.leetcode.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeStringAlternatelyTest {
    MergeStringAlternately mergeStringAlternately = new MergeStringAlternately();

    @Test
    void test01() {
        assertThat(mergeStringAlternately.mergeAlternately("abc", "pqr"))
                .isEqualTo("apbqcr");
    }


    @Test
    void test02() {
        assertThat(mergeStringAlternately.mergeAlternately("ab", "pqrs"))
                .isEqualTo("apbqrs");
    }


    @Test
    void test03() {
        assertThat(mergeStringAlternately.mergeAlternately("abcd", "pq"))
                .isEqualTo("apbqcd");
    }
}
