package com.study.leetcode.graph;

import com.study.leetcode.common.Node;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CloneGraphTest {
    CloneGraph cloneGraph = new CloneGraph();

    @Test
    void test1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node cloneGraph1 = cloneGraph.cloneGraph(node1);

        // 클론된 그래프 테스트
        assertNodeEquals(node1, cloneGraph1, new HashSet<>());
    }

    private void assertNodeEquals(Node expected, Node actual, Set<Node> visited) {
        assertThat(actual).isNotNull();
        assertThat(actual.val).isEqualTo(expected.val);
        assertThat(actual.neighbors).isNotNull();
        assertThat(actual.neighbors).hasSameSizeAs(expected.neighbors);

        visited.add(actual);

        for (int i = 0; i < expected.neighbors.size(); i++) {
            Node expectedNeighbor = expected.neighbors.get(i);
            Node actualNeighbor = actual.neighbors.get(i);

            if (!visited.contains(actualNeighbor)) {
                assertNodeEquals(expectedNeighbor, actualNeighbor, visited);
            }
        }
    }

    @Test
    void test2() {
        Node node1 = new Node();
        Node cloneGraph1 = cloneGraph.cloneGraph(node1);
        // 클론된 그래프 테스트
        assertNodeEquals(node1, cloneGraph1, new HashSet<>());
    }
}