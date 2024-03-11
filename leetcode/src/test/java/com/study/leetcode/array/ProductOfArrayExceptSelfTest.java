package com.study.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductOfArrayExceptSelfTest {
    ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();

    @Test
    void test01() {
        assertThat(productOfArrayExceptSelf.productExceptSelf(new int[]{1,2,3,4}))
                .containsExactly(24, 12, 8, 6);
    }

}
