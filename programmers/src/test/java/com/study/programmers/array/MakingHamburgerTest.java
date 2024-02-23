package com.study.programmers.array;

import com.study.programmers.array.MakingHamburger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakingHamburgerTest {
    MakingHamburger makingHamburger = new MakingHamburger();

    @Test
    void test1() {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        assertThat(makingHamburger.makingHamburger(ingredient))
                .isEqualTo(2);
    }

    @Test
    void test2() {
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        assertThat(makingHamburger.makingHamburger(ingredient))
                .isEqualTo(0);
    }
}
