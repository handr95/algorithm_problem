package com.study.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MajorityElementTest {
    MajorityElement majorityElement = new MajorityElement();

    @Test
    void test01() {
        assertThat(majorityElement.majorityElement(new int[]{3,2,3}))
                .isEqualTo(3);
    }

    @Test
    void test02() {
        assertThat(majorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}))
                .isEqualTo(2);
    }
}
