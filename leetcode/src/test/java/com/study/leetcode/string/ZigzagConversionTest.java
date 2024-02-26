package com.study.leetcode.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ZigzagConversionTest {
    ZigzagConversion zigzagConversion = new ZigzagConversion();

    @Test
    void test1() {
        assertThat(zigzagConversion.convert("PAYPALISHIRING", 3))
                .isEqualTo("PAHNAPLSIIGYIR");
    }

    @Test
    void test2() {
        assertThat(zigzagConversion.convert("PAYPALISHIRING", 4))
                .isEqualTo("PINALSIGYAHRPI");
    }

    @Test
    void test3() {
        assertThat(zigzagConversion.convert("A", 1))
                .isEqualTo("A");
    }
}
