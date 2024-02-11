package com.study.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YearningScoreTest {
    YearningScore yearningScore = new YearningScore();

    @Test
    void test1(){
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        assertThat(yearningScore.solution(name, yearning, photo))
                .containsExactly(19, 15, 6);
    }

    @Test
    void test2(){
        String[] name = {"kali", "mari", "don"};
        int[] yearning = {11, 1, 55};
        String[][] photo = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};

        assertThat(yearningScore.solution(name, yearning, photo))
                .containsExactly(67, 0, 55);
    }

    @Test
    void test3(){
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"},{"kein", "deny", "may"},{"kon", "coni"}};

        assertThat(yearningScore.solution(name, yearning, photo))
                .containsExactly(5, 15, 0);
    }
}
