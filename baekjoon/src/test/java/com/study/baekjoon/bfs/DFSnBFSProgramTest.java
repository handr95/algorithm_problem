package com.study.baekjoon.bfs;

import com.study.baekjoon.dfs.BaekjoonBaseTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.study.baekjoon.bfs.DFSnBFSProgram.dfsAndBfsProgram;

class DFSnBFSProgramTest extends BaekjoonBaseTest {

    @Test
    void test01() throws IOException {
        String input = "4 5 1\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "2 4\n" +
                "3 4\n";

        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        dfsAndBfsProgram();

        // 예상되는 출력 결과
        String expectedOutput = "1 2 4 3\n" +
                "1 2 3 4\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }

    @Test
    void test02() throws IOException {
        String input = "5 5 3\n" +
                "5 4\n" +
                "5 2\n" +
                "1 2\n" +
                "3 4\n" +
                "3 1\n";

        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        dfsAndBfsProgram();

        // 예상되는 출력 결과
        String expectedOutput = "3 1 2 5 4\n" +
                "3 1 4 2 5\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }
}
