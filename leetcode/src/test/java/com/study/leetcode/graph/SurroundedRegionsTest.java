package com.study.leetcode.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SurroundedRegionsTest {

    SurroundedRegions surroundedRegions = new SurroundedRegions();


    @Test
    void test1() {
        char[][] input = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] expect = {{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}};
        surroundedRegions.surroundedRegions(input);
        assertThat(input).isEqualTo(expect);
    }

    @Test
    void test2() {
        char[][] input = {{'X'}};
        char[][] expect = {{'X'}};
        surroundedRegions.surroundedRegions(input);
        assertThat(input).isEqualTo(expect);
    }

    @Test
    void test3() {
        char[][] input = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        char[][] expect = {{'X','O','X','O','X','O'},{'O','X','X','X','X','X'},{'X','X','X','X','X','O'},{'O','X','O','X','O','X'}};
        surroundedRegions.surroundedRegions(input);
        assertThat(input).isEqualTo(expect);
    }

    @Test
    void test4() {
        char[][] input = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        char[][] expect = {{'O','X','X','O','X'},{'X','X','X','X','O'},{'X','X','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        surroundedRegions.surroundedRegions(input);
        assertThat(input).isEqualTo(expect);
    }
}
