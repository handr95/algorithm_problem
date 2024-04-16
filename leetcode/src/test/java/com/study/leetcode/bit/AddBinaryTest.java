package com.study.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddBinaryTest {
    AddBinary addBinary = new AddBinary();

    @Test
    void test1(){
        assertThat(addBinary.addBinary("11", "1")).isEqualTo("100");
    }

    @Test
    void test2(){
        assertThat(addBinary.addBinary("0", "0")).isEqualTo("0");
    }
    @Test
    void test3(){
        assertThat(addBinary.addBinary("1010", "1011")).isEqualTo("10101");
    }
}
