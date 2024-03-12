package com.study.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DetermineIfTwoStringsAreCloseTest {

    DetermineIfTwoStringsAreClose determineIfTwoStringsAreClose = new DetermineIfTwoStringsAreClose();

    @Test
    void test01() {
        String word1 = "abc";
        String word2 = "bca";
        assertThat(determineIfTwoStringsAreClose.closeStrings(word1, word2))
                .isTrue();
    }

    @Test
    void test02() {
        String word1 = "a";
        String word2 = "aa";
        assertThat(determineIfTwoStringsAreClose.closeStrings(word1, word2))
                .isFalse();
    }

    @Test
    void test03() {
        String word1 = "cabbba";
        String word2 = "abbccc";
        assertThat(determineIfTwoStringsAreClose.closeStrings(word1, word2))
                .isTrue();
    }

    @Test
    void test04() {
        String word1 = "abbzzca";
        String word2 = "babzzcz";
        assertThat(determineIfTwoStringsAreClose.closeStrings(word1, word2))
                .isFalse();
    }
}
