package com.study.programmers.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringDescTest {
    StringDesc stringDesc = new StringDesc();

    @Test
    void test1() {
        String s  = "Zbcdefg";
        assertThat(stringDesc.solution(s))
                .isEqualTo("gfedcbZ");
    }
}
