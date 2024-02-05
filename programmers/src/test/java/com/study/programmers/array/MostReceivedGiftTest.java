package com.study.programmers.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MostReceivedGiftTest {
    MostReceivedGift mostReceivedGift = new MostReceivedGift();

    @Test
    void test1() {
        String[] fiends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        assertThat(mostReceivedGift.mostReceivedGift(fiends, gifts)).isEqualTo(2);
    }

    @Test
    void test2() {
        String[] fiends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        assertThat(mostReceivedGift.mostReceivedGift(fiends, gifts)).isEqualTo(4);
    }

    @Test
    void test3() {
        String[] fiends = {"a", "b", "c"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
        assertThat(mostReceivedGift.mostReceivedGift(fiends, gifts)).isEqualTo(0);
    }
}
