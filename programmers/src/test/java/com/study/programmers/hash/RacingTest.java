package com.study.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    Racing racing = new Racing();

    @Test
    void test1() {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        assertThat(racing.solution(players, callings))
                .containsExactly("mumu", "kai", "mine", "soe", "poe");
    }
}
