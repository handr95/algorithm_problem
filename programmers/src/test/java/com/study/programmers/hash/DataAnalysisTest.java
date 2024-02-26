package com.study.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DataAnalysisTest {
    DataAnalysis dataAnalysis = new DataAnalysis();

    @Test
    void test1() {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        int[][] expectData = {{3,20300401,10,8},{1,20300104,100,80}};
        assertThat(dataAnalysis.dataAnalysis(data, ext, val_ext, sort_by))
                .isEqualTo(expectData);

    }
}
