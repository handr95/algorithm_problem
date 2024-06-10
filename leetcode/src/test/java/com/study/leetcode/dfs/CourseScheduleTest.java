package com.study.leetcode.dfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CourseScheduleTest {
    CourseSchedule courseSchedule = new CourseSchedule();

    @Test
    void test1() {
        assertThat(courseSchedule.canFinish(2, new int[][]{{1,0}}))
                .isTrue();
    }

    @Test
    void test2() {
        assertThat(courseSchedule.canFinish(2, new int[][]{{1,0}, {0,1}}))
                .isFalse();
    }
}
