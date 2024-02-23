package com.study.programmers.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodFightCompetitionTest {
    FoodFightCompetition foodFightCompetition = new FoodFightCompetition();

    @Test
    void test1() {
        int[] food = {1, 3, 4, 6};
        assertThat(foodFightCompetition.foodFightCompetition(food))
                .isEqualTo("1223330333221");
    }

    @Test
    void test2() {
        int[] food = {1, 7, 1, 2};
        assertThat(foodFightCompetition.foodFightCompetition(food))
                .isEqualTo("111303111");
    }
}
