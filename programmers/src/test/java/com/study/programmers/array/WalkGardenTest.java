package com.study.programmers.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WalkGardenTest {
    WalkGarden walkGarden = new WalkGarden();

    @Test
    void test1() {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        assertThat(walkGarden.solution(park, routes))
                .containsExactly(2,1);
    }
    @Test
    void test2() {
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        assertThat(walkGarden.solution(park, routes))
                .containsExactly(0,1);
    }
    @Test
    void test3() {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        assertThat(walkGarden.solution(park, routes))
                .containsExactly(0,0);
    }
}
