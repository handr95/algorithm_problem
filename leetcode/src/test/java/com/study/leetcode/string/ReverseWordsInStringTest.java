package com.study.leetcode.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseWordsInStringTest {

    ReverseWordsInString reverseWordsInString = new ReverseWordsInString();

    @Test
    void test01(){
        assertThat(reverseWordsInString.reverseWords("the sky is blue"))
                .isEqualTo("blue is sky the");
    }

    @Test
    void test02(){
        assertThat(reverseWordsInString.reverseWords("  hello world  "))
                .isEqualTo("world hello");
    }


    @Test
    void test03(){
        assertThat(reverseWordsInString.reverseWords("a good   example"))
                .isEqualTo("example good a");
    }
}

