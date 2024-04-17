package com.study.baekjoon.bfs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BaekjoonBaseTest {

    public ByteArrayOutputStream baseTestBefore(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // 출력 결과를 캡처하기 위한 ByteArrayOutputStream 생성
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        return outputStream;
    }
    public void baseTestAfter(ByteArrayOutputStream outputStream, String expectedOutput) {
        // 실제 출력 결과
        String actualOutput = outputStream.toString().trim() + "\n";

        // 예상되는 출력과 실제 출력이 같은지 확인
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
