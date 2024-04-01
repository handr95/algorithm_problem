package com.study.leetcode.twopoint;

import com.study.leetcode.twopiont.IsSubsequence;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class IsSubsequenceTest {
    IsSubsequence isSubsequence = new IsSubsequence();

    @Test
    void test1() {
        assertThat(isSubsequence.isSubsequence("abc", "ahbgdc")).isTrue();
    }

    @Test
    void test2() {
        assertThat(isSubsequence.isSubsequence("axc", "ahbgdc")).isFalse();
    }

    @Test
    void test3() {
        assertThat(isSubsequence.isSubsequence("aaaaaa", "bbaaaa")).isFalse();
    }
}
