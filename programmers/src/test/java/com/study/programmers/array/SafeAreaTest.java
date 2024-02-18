package com.study.programmers.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SafeAreaTest {
    SafeArea safeArea = new SafeArea();
    @Test
    void test1() {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        assertThat(safeArea.solution(board)).isEqualTo(16);
    }

    @Test
    void test2() {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
        assertThat(safeArea.solution(board)).isEqualTo(13);
    }

    @Test
    void test3() {
        int[][] board = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};
        assertThat(safeArea.solution(board)).isEqualTo(0);
    }
}