package com.study.leetcode.twopoint;

import com.study.leetcode.twopiont.MoveZeroes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveZeroesTest {
    MoveZeroes moveZeroes = new MoveZeroes();

    @Test
    void test1() {
        int[] param = {0,1,0,3,12};
        moveZeroes.moveZeroes(param);
        assertThat(param).isEqualTo(new int[]{1,3,12,0,0});
    }
    @Test
    void test2() {
        int[] param = {0};
        moveZeroes.moveZeroes(param);
        assertThat(param).isEqualTo(new int[]{0});
    }
}
