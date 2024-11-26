package com.study.leetcode.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreOfStringTest {
    ScoreOfString scoreOfString = new ScoreOfString();

    @Test
    void test01() {
        assertThat(scoreOfString.scoreOfString("hello")).isEqualTo(13);
    }

    @Test
    void test02() {
        assertThat(scoreOfString.scoreOfString("zaz")).isEqualTo(50);
    }
}
