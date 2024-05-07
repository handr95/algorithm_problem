package com.study.baekjoon.dfs;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.study.baekjoon.dfs.FindFriendship.findFriendship;

class FindingFriendshipTest extends BaekjoonBaseTest {

    @Test
    void test01() throws IOException {
        String input = "5 4\n" +
                "0 1\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n";
        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        findFriendship();

        // 예상되는 출력 결과
        String expectedOutput = "1\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }

    @Test
    void test02() throws IOException {
        String input = "5 5\n" +
                "0 1\n" +
                "1 2\n" +
                "2 3\n" +
                "3 0\n" +
                "1 4\n";
        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        findFriendship();

        // 예상되는 출력 결과
        String expectedOutput = "1\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }

    @Test
    void test03() throws IOException {
        String input = "6 5\n" +
                "0 1\n" +
                "0 2\n" +
                "0 3\n" +
                "0 4\n" +
                "0 5\n";
        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        findFriendship();

        // 예상되는 출력 결과
        String expectedOutput = "0\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }

    @Test
    void test04() throws IOException {
        String input = "8 8\n" +
                "1 7\n" +
                "3 7\n" +
                "4 7\n" +
                "3 4\n" +
                "4 6\n" +
                "3 5\n" +
                "0 4\n" +
                "2 7\n";
        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        findFriendship();

        // 예상되는 출력 결과
        String expectedOutput = "1\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }
}
