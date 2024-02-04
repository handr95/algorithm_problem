package com.study.programmers.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LifeBoatTest {
    LifeBoat lifeBoat = new LifeBoat();

    @Test
    void test1() {
        int[] people = {70, 50, 70, 50};
        int limit = 100;
        assertThat(lifeBoat.solution(people, limit))
                .isEqualTo(3);
    }

    @Test
    void test2() {
        int[] people = {70, 80, 50};
        int limit = 100;
        assertThat(lifeBoat.solution(people, limit))
                .isEqualTo(3);
    }

    @Test
    void test3() {
        int[] people = {70, 80, 50, 100, 50};
        int limit = 100;
        assertThat(lifeBoat.solution(people, limit))
                .isEqualTo(4);
    }

    @Test
    void test4() {
        int[] people = {10, 20, 80, 50};
        int limit = 100;
        assertThat(lifeBoat.solution(people, limit))
                .isEqualTo(2);
    }

    @Test
    void test5() {
        int[] people = {10, 10, 10, 10, 10, 20, 80, 50};
        int limit = 100;
        assertThat(lifeBoat.lifeBoat(people, limit))
                .isEqualTo(4);
    }

    @Test
    void test6() {
        int[] people = {10, 10, 10, 10, 10, 20, 80, 50, 20, 50, 40};
        int limit = 100;
        assertThat(lifeBoat.lifeBoat(people, limit))
                .isEqualTo(6);
    }

    @Test
    void test7() {
        int[] people = {100, 20, 180, 40, 80, 20, 80, 50};
        int limit = 200;
        assertThat(lifeBoat.lifeBoat(people, limit))
                .isEqualTo(4);
    }
}
