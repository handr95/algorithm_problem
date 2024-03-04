package com.study.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LetterCombinationsOfPhoneNumberTest {
    LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();

    @Test
    void test1() {
        assertThat(letterCombinationsOfPhoneNumber.letterCombinations("23"))
                .containsExactly("ad","ae","af","bd","be","bf","cd","ce","cf");
    }

    @Test
    void test2() {
        assertThat(letterCombinationsOfPhoneNumber.letterCombinations(""))
                .isEmpty();
    }

    @Test
    void test3() {
        assertThat(letterCombinationsOfPhoneNumber.letterCombinations("2"))
                .containsExactly("a","b","c");
    }
}
