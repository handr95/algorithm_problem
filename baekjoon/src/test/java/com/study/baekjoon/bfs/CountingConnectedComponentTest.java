package com.study.baekjoon.bfs;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

class CountingConnectedComponentTest {

    @Test
    void testCountingConnectedComponent() throws IOException {
        // Prepare input data
        String input = "6 5\n" +
                       "1 2\n" +
                       "2 5\n" +
                       "5 1\n" +
                       "3 4\n" +
                       "4 6\n";

        // Set up the standard input stream with the input data
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        // Perform the test
        CountingConnectedComponent.countingConnectedComponent();

        // Restore standard input
        System.setIn(stdin);
    }
}