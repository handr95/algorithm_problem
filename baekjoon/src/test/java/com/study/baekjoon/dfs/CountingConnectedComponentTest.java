package com.study.baekjoon.dfs;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.study.baekjoon.dfs.CountingConnectedComponent.countingConnectedComponent;

class CountingConnectedComponentTest extends BaekjoonBaseTest {
    @Test
    void testMain1() throws IOException {
        // 입력 시뮬레이션을 위한 바이트 배열 생성
        String input = "6 5\n" +
                "1 2\n" +
                "2 5\n" +
                "5 1\n" +
                "3 4\n" +
                "4 6\n";
        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        // Main 클래스의 main 메서드 실행
        countingConnectedComponent();

        // 예상되는 출력 결과
        String expectedOutput = "2\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }

    @Test
    void testMain2() throws IOException {
        // 입력 시뮬레이션을 위한 바이트 배열 생성
        String input = "6 8\n" +
                "1 2\n" +
                "2 5\n" +
                "5 1\n" +
                "3 4\n" +
                "4 6\n" +
                "5 4\n" +
                "2 4\n" +
                "2 3\n";
        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        // Main 클래스의 main 메서드 실행
        countingConnectedComponent();

        // 예상되는 출력 결과
        String expectedOutput = "1\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }
}