package com.study.baekjoon.dfs;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


class FindingAmazingPrimeNumberTest extends BaekjoonBaseTest{

    @Test
    void test1() throws IOException {
        String input = "4";
        ByteArrayOutputStream byteArrayOutputStream = baseTestBefore(input);
        FindAmazingPrimeNumbers.findAmazingPrimeNumbers();

        // 예상되는 출력 결과
        String expectedOutput = "2333\n" +
                "2339\n" +
                "2393\n" +
                "2399\n" +
                "2939\n" +
                "3119\n" +
                "3137\n" +
                "3733\n" +
                "3739\n" +
                "3793\n" +
                "3797\n" +
                "5939\n" +
                "7193\n" +
                "7331\n" +
                "7333\n" +
                "7393\n";
        baseTestAfter(byteArrayOutputStream, expectedOutput);
    }
}
