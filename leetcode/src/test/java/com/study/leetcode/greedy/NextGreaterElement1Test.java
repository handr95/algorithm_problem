package com.study.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextGreaterElement1Test {
    NextGreaterElement1 nextGreaterElement1 = new NextGreaterElement1();

    @Test
    void test1() {
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        assertThat(nextGreaterElement1.nextGreaterElement(num1, num2))
                .containsExactly(-1, 3, -1);
    }

    @Test
    void test2() {
        int[] num1 = {2,4};
        int[] num2 = {1,2,3,4};
        assertThat(nextGreaterElement1.nextGreaterElement(num1, num2))
                .containsExactly(3, -1);
    }
    @Test
    void test3() {
        int[] num1 = {1,3,5,2,4};
        int[] num2 = {6,5,4,3,2,1,7};
        assertThat(nextGreaterElement1.nextGreaterElement(num1, num2))
                .containsExactly(7,7,7,7,7);
    }
}
