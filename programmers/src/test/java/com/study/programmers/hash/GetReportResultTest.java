package com.study.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GetReportResultTest {
    GetReportResult getReportResult = new GetReportResult();

    @Test
    void test1() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        assertThat(getReportResult.getReportResult(id_list, report, k))
                .containsExactly(2,1,1,0);
    }

    @Test
    void test2() {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        assertThat(getReportResult.getReportResult(id_list, report, k))
                .containsExactly(0,0);
    }
}
