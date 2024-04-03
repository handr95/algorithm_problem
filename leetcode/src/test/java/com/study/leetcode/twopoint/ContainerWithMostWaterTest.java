package com.study.leetcode.twopoint;

import com.study.leetcode.twopiont.ContainerWithMostWater;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @Test
    void test01() {
        assertThat(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}))
                .isEqualTo(49);
    }

    @Test
    void test02() {
        assertThat(containerWithMostWater.maxArea(new int[]{1,1}))
                .isEqualTo(1);
    }
}
