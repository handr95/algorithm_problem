package com.study.leetcode.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfIslandsTest {
    NumberOfIslands numberOfIslands = new NumberOfIslands();

    @Test
    void test1() {
        char[][] input = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        assertThat(numberOfIslands.numberOfIslands(input)).isEqualTo(1);
    }

    @Test
    void test2() {
        char[][] input = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        assertThat(numberOfIslands.numberOfIslands(input)).isEqualTo(3);
    }
}
