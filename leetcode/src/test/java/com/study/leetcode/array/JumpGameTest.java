package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JumpGameTest {
    JumpGame jumpGame = new JumpGame();

    @Test
    void test01() {
        assertThat(jumpGame.canJump(new int[]{2,3,1,1,4})).isTrue();
    }

    @Test
    void test02() {
        assertThat(jumpGame.canJump(new int[]{3,2,1,0,4})).isFalse();
    }

    @Test
    void test03() {
        assertThat(jumpGame.canJump(new int[]{2,5,0,0})).isTrue();
    }
    @Test
    void test04() {
        assertThat(jumpGame.canJump(new int[]{0,1})).isFalse();
    }
}
