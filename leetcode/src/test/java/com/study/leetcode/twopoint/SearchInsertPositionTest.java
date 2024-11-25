package com.study.leetcode.twopoint;

import com.study.leetcode.twopiont.SearchInsertPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInsertPositionTest {
    SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

    @Test
    void test1() {
        int[] param = {1,3,5,6};
        assertThat(searchInsertPosition.searchInsert(param, 5)).isEqualTo(2);
    }

    @Test
    void test2() {
        int[] param = {1,3,5,6};
        assertThat(searchInsertPosition.searchInsert(param, 2)).isEqualTo(1);
    }
    @Test
    void test3() {
        int[] param = {1,3,5,6};
        assertThat(searchInsertPosition.searchInsert(param, 7)).isEqualTo(4);
    }
}
