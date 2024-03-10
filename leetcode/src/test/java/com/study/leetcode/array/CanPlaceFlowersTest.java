package com.study.leetcode.array;

import com.study.leetcode.array.CanPlaceFlowers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CanPlaceFlowersTest {
    CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

    @Test
    void test01() {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;

        assertThat(canPlaceFlowers.canPlaceFlowers(flowerbed, n))
                .isTrue();
    }

    @Test
    void test02() {
        int[] flowerbed = {1,0,0,0,1};
        int n = 2;

        assertThat(canPlaceFlowers.canPlaceFlowers(flowerbed, n))
                .isFalse();
    }
}
