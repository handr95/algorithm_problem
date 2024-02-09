package com.study.programmers.dfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapShortestDistanceTest {
    MapShortestDistance mapShortestDistance = new MapShortestDistance();

    @Test
    void test1() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        assertThat(mapShortestDistance.mapShortestDistance(maps)).isEqualTo(11);
    }

    /**
     * {1,0,1,1,1},
     * {1,0,1,0,1},
     * {1,0,1,1,1},
     * {1,1,1,0,0},
     * {0,0,0,0,1}
     */
    @Test
    void test2() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        assertThat(mapShortestDistance.mapShortestDistance(maps)).isEqualTo(-1);
    }
}
