package com.study.programmers.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GymClothesTest {
    GymClothes gymClothes = new GymClothes();

    @Test
    void test1() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(5);
    }

    @Test
    void test2() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(4);
    }

    @Test
    void test3() {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(2);
    }

    @Test
    void test4() {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(2);
    }

    @Test
    void test5() {
        int n = 10;
        int[] lost = {1,3,7};
        int[] reserve = {2,8};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(9);
    }

    @Test
    void test6() {
        int n = 10;
        int[] lost = {};
        int[] reserve = {};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(10);
    }

    @Test
    void test7() {
        int n = 2;
        int[] lost = {1,2};
        int[] reserve = {};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(0);
    }

    @Test
    void test8() {
        int n = 2;
        int[] lost = {};
        int[] reserve = {2, 4};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(2);
    }

    @Test
    void test9() {
        int n = 10;
        int[] lost = {1,2,3,4,5,7,8,9};
        int[] reserve = {6};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(3);
    }

    @Test
    void test10() {
        int n = 10;
        int[] lost = {1,2,5,7,8,9};
        int[] reserve = {2,3,6};

        assertThat(gymClothes.solution(n, lost, reserve))
                .isEqualTo(6);
    }
}
