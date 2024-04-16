package com.study.leetcode.dfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FloodFillTest {
    FloodFill floodFill = new FloodFill();

    @Test
    public void test1() {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] expect = {{2,2,2},{2,2,0},{2,0,1}};
        assertThat(floodFill.floodFill(image, 1, 1, 2))
                .isEqualTo(expect);
    }

    @Test
    public void test2() {
        int[][] image = {{0,0,0},{0,0,0}};
        int[][] expect = {{0,0,0},{0,0,0}};
        assertThat(floodFill.floodFill(image, 0, 0, 0))
                .isEqualTo(expect);
    }
}