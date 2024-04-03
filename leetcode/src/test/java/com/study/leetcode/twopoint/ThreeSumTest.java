package com.study.leetcode.twopoint;

import com.study.leetcode.twopiont.ThreeSum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeSumTest {
    ThreeSum threeSum = new ThreeSum();

    @Test
    void test01() {
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(-1,-1,2));
        expect.add(Arrays.asList(-1,0,1));
        assertThat(threeSum.threeSum2(new int[]{-1,0,1,2,-1,-4}))
                .isEqualTo(expect);
    }

    @Test
    void test02() {
        assertThat(threeSum.threeSum2(new int[]{0,1,1}))
                .isEmpty();
    }

    @Test
    void test03() {
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(0,0,0));
        assertThat(threeSum.threeSum2(new int[]{0,0,0}))
                .isEqualTo(expect);
    }

    @Test
    void test04() {
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(-4,0,4));
        expect.add(Arrays.asList(-4,1,3));
        expect.add(Arrays.asList(-3,-1,4));
        expect.add(Arrays.asList(-3,0,3));
        expect.add(Arrays.asList(-3,1,2));
        expect.add(Arrays.asList(-2,-1,3));
        expect.add(Arrays.asList(-2,0,2));
        expect.add(Arrays.asList(-1,-1,2));
        expect.add(Arrays.asList(-1,0,1));

        assertThat(threeSum.threeSum2(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}))
                .isEqualTo(expect);
    }

    @Test
    void test05() {
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(-5,1,4));
        expect.add(Arrays.asList(-4,0,4));
        expect.add(Arrays.asList(-4,1,3));
        expect.add(Arrays.asList(-2,-2,4));
        expect.add(Arrays.asList(-2,1,1));
        expect.add(Arrays.asList(0,0,0));

        assertThat(threeSum.threeSum2(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}))
                .isEqualTo(expect);
    }

    public static List<List<Integer>> stringToListOfLists(String input) {
        List<List<Integer>> listOfLists = new ArrayList<>();

        input = input.substring(1, input.length() - 1);

        // Remove leading and trailing square brackets
        String[] arrays = input.substring(1, input.length() - 1).split("\\],\\[");

        for (String array : arrays) {
            List<Integer> list = new ArrayList<>();
            // Split the array by comma and convert each element to integer
            String[] elements = array.split(",");
            for (String element : elements) {
                list.add(Integer.parseInt(element));
            }
            listOfLists.add(list);
        }

        return listOfLists;
    }
}
