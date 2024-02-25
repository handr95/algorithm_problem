package com.study.programmers.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlusNumbersTest {
    PlusNumbers plusNumbers = new PlusNumbers();

    @Test
    void test1() {
        int[] numbers = {2,1,3,4,1};
        assertThat(plusNumbers.plusNumbers(numbers))
                .containsExactly(2,3,4,5,6,7);
    }
}
