package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeNumberTest {
    PalindromeNumber palindromeNumber = new PalindromeNumber();

    @Test
    void test1() {
        int input = 121;
        boolean result = palindromeNumber.isPalindrome(input);
        assertThat(result).isTrue();
    }
    @Test
    void test2() {
        int input = -121;
        boolean result = palindromeNumber.isPalindrome(input);
        assertThat(result).isFalse();
    }
    @Test
    void test3() {
        int input = 10;
        boolean result = palindromeNumber.isPalindrome(input);
        assertThat(result).isFalse();
    }
}