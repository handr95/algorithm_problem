package com.study.leetcode.hashtable;

import com.study.leetcode.hashtable.LongestSubstringWithoutRepeatingCharacters;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringWithoutRepeatingCharactersTest {
    LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
            new LongestSubstringWithoutRepeatingCharacters();

    @Test
    void test1() {
        String input = "abcabcbb";
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void test2() {
        String input = "bbbbb";
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void test3() {
        String input = "pwwkew";
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void test4() {
        String input = "";
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void test5() {
        String input = "dvdf";
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
        assertThat(result).isEqualTo(3);
    }
}
