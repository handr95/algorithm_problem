package com.study.leetcode.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestCommonPrefixTest {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    @Test
    void test1() {
        String[] strs = {"flower","flow","flight"};
        assertThat(longestCommonPrefix.longestCommonPrefix(strs))
                .isEqualTo("fl");
    }

    @Test
    void test2() {
        String[] strs = {"","abc","def"};
        assertThat(longestCommonPrefix.longestCommonPrefix(strs))
                .isEqualTo("");
    }

    @Test
    void test3() {
        String[] strs = {"dog","racecar","car"};
        assertThat(longestCommonPrefix.longestCommonPrefix(strs))
                .isEqualTo("");
    }
}
