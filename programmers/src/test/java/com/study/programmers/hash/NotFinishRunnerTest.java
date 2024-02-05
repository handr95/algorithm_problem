package com.study.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NotFinishRunnerTest {
    NotFinishRunner notFinishRunner = new NotFinishRunner();
    @Test
    void test1() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        assertThat(notFinishRunner.notFinishRunner(participant, completion))
                .isEqualTo("leo");
    }

    @Test
    void test2() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        assertThat(notFinishRunner.notFinishRunner(participant, completion))
                .isEqualTo("vinko");
    }

    @Test
    void test3() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        assertThat(notFinishRunner.notFinishRunner(participant, completion))
                .isEqualTo("mislav");
    }
}
