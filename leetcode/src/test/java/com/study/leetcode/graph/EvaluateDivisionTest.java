package com.study.leetcode.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluateDivisionTest {
    EvaluateDivision evaluateDivision = new EvaluateDivision();

    @Test
    void testExample1() {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        double[] expectedResult = {6.0, 0.5, -1.0, 1.0, -1.0};

        double[] actualResult = evaluateDivision.calcEquation(equations, values, queries);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testExample2() {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd"));
        double[] values = {1.5, 2.5, 5.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("c", "b"), Arrays.asList("bc", "cd"), Arrays.asList("cd", "bc"));
        double[] expectedResult = {3.75, 0.4, 5.0, 0.2};

        double[] actualResult = evaluateDivision.calcEquation(equations, values, queries);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testExample3() {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"));
        double[] values = {0.5};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "a"), Arrays.asList("a", "c"), Arrays.asList("x", "y"));
        double[] expectedResult = {0.5, 2.0, -1.0, -1.0};

        double[] actualResult = evaluateDivision.calcEquation(equations, values, queries);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testExample4() {
        List<List<String>> equations = Arrays.asList(Arrays.asList("x1", "x2"), Arrays.asList("x2", "x3"), Arrays.asList("x3", "x4"), Arrays.asList("x4", "x5"));
        double[] values = {3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("x1", "x5"), Arrays.asList("x5", "x2"), Arrays.asList("x2", "x4"), Arrays.asList("x2", "x2"), Arrays.asList("x2", "x9"), Arrays.asList("x9", "x9"));
        double[] expectedResult = {360.00000, 0.008333333333333333, 20.00000, 1.00000, -1.00000, -1.00000};

        double[] actualResult = evaluateDivision.calcEquation(equations, values, queries);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testExample5() {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("e", "f"), Arrays.asList("b", "e"));
        double[] values = {3.4, 1.4, 2.3};
        List<List<String>> queries = Arrays.asList(Arrays.asList("b", "a"), Arrays.asList("a", "f"), Arrays.asList("f", "f"), Arrays.asList("e", "e"), Arrays.asList("c", "c"), Arrays.asList("a", "c"), Arrays.asList("f", "e"));
        double[] expectedResult = {0.29411764705882354, 10.947999999999999, 1.00000, 1.00000, -1.00000, -1.00000, 0.7142857142857143};

        double[] actualResult = evaluateDivision.calcEquation(equations, values, queries);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
