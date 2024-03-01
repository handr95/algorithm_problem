package com.study.leetcode.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringToIntegerTest {
    StringToInteger stringToInteger = new StringToInteger();
    @Test
    void test1() {
        assertThat(stringToInteger.stringToInteger("42"))
                .isEqualTo(42);
    }

    @Test
    void test2() {
        assertThat(stringToInteger.stringToInteger("   -42"))
                .isEqualTo(-42);
    }

    @Test
    void test3() {
        assertThat(stringToInteger.stringToInteger("4193 with words"))
                .isEqualTo(4193);
    }

    @Test
    void test4() {
        assertThat(stringToInteger.stringToInteger("words and 987"))
                .isEqualTo(0);
    }
    @Test
    void test5() {
        assertThat(stringToInteger.stringToInteger("-91283472332"))
                .isEqualTo(-2147483648);
    }

    @Test
    void test6() {
        assertThat(stringToInteger.stringToInteger("30.13"))
                .isEqualTo(30);
    }

    @Test
    void test7() {
        assertThat(stringToInteger.stringToInteger("00000-42a1234"))
                .isEqualTo(0);
    }

    @Test
    void test8() {
        assertThat(stringToInteger.stringToInteger("9223372036854775808"))
                .isEqualTo(2147483647);
    }


    @Test
    void test9() {
        assertThat(stringToInteger.stringToInteger("   +0 123"))
                .isEqualTo(0);
    }
}
