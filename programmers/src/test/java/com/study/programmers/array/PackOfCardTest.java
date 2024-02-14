package com.study.programmers.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PackOfCardTest {
    PackOfCard packOfCard = new PackOfCard();

    @Test
    void test1() {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        assertThat(packOfCard.solution(cards1, cards2, goal))
                .isEqualTo("Yes");
    }

    @Test
    void test2() {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        assertThat(packOfCard.solution(cards1, cards2, goal))
                .isEqualTo("No");
    }
}
