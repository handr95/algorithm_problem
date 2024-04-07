package com.study.leetcode.twopoint;

import com.study.leetcode.twopiont.FindTheIndexOfTheFirstOccurrenceInAString;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheIndexOfTheFirstOccurrenceInAStringTest {
    FindTheIndexOfTheFirstOccurrenceInAString findTheIndexOfTheFirstOccurrenceInAString = new FindTheIndexOfTheFirstOccurrenceInAString();

    @Test
    void test1() {
        assertThat(findTheIndexOfTheFirstOccurrenceInAString.findTheIndexOfTheFirstOccurrenceInAString("sadbutsad", "sad"))
                .isEqualTo(0);
    }

    @Test
    void test2() {
        assertThat(findTheIndexOfTheFirstOccurrenceInAString.findTheIndexOfTheFirstOccurrenceInAString("leetcode", "leeto"))
                .isEqualTo(-1);
    }
}
