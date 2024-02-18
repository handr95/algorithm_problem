package com.study.programmers.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurseNumberTest {
    CurseNumber curseNumber = new CurseNumber();

    @Test
    void test1(){
        assertThat(curseNumber.solution(15))
                .isEqualTo(25);
    }
    @Test
    void test2(){
        assertThat(curseNumber.solution(40))
                .isEqualTo(76);
    }
}
