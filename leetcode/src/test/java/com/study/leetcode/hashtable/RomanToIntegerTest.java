package com.study.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntegerTest {
    @Test
    void usingHashMap_test1() {
        String input = "III";
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void usingHashMap_test2() {
        String input = "LVIII";
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt(input);
        assertThat(result).isEqualTo(58);
    }

    @Test
    void usingHashMap_test3() {
        String input = "MCMXCIV";
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt(input);
        assertThat(result).isEqualTo(1994);
    }

    @Test
    void solution_test1() {
        String input = "III";
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToIntSolution(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void solution_test2() {
        String input = "LVIII";
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToIntSolution(input);
        assertThat(result).isEqualTo(58);
    }

    @Test
    void solution_test3() {
        String input = "MCMXCIV";
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToIntSolution(input);
        assertThat(result).isEqualTo(1994);
    }
}
