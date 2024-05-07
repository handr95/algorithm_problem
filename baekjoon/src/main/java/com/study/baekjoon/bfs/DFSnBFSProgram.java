package com.study.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/***
 * 1260번 DFS와 BFS
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 * 2 초	128 MB	284648	111203	66096	37.767%
 * https://www.acmicpc.net/problem/1260
 * 난이도 : 실버 2
 *
 * 문제
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 *
 * 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 *
 * 출력
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 *
 * 예제 입력 1
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * 예제 출력 1
 * 1 2 4 3
 * 1 2 3 4
 *
 * 예제 입력 2
 * 5 5 3
 * 5 4
 * 5 2
 * 1 2
 * 3 4
 * 3 1
 * 예제 출력 2
 * 3 1 2 5 4
 * 3 1 4 2 5
 *
 * 예제 입력 3
 * 1000 1 1000
 * 999 1000
 * 예제 출력 3
 * 1000 999
 * 1000 999
 */
public class DFSnBFSProgram {
    static List<Integer>[] linkedInfo;
    static Set<Integer> visited;
    static StringBuilder dfsResult;
    static StringBuilder bfsResult;

    public static void dfsAndBfsProgram() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeQty = Integer.parseInt(st.nextToken());   // 노드의 개수
            int edgeQty = Integer.parseInt(st.nextToken());   // 에지의 개수
            int searchStartNode = Integer.parseInt(st.nextToken());   // 시작 노드

            linkedInfo = new ArrayList[nodeQty + 1];
            visited = new HashSet<>();

            for (int i = 1; i < nodeQty + 1; i++) {
                linkedInfo[i] = new ArrayList<>();
            }

            for (int i = 0; i < edgeQty; i++) {
                st = new StringTokenizer(br.readLine());
                int startNode = Integer.parseInt(st.nextToken());
                int endNode = Integer.parseInt(st.nextToken());
                linkedInfo[startNode].add(endNode);
                linkedInfo[endNode].add(startNode);
            }
            for (int i = 1; i < nodeQty + 1; i++) {
                List<Integer> integers = linkedInfo[i];
                Collections.sort(integers);
            }

            dfsResult = new StringBuilder();
            dfs(searchStartNode);
            System.out.println(dfsResult.toString());

            bfsResult = new StringBuilder();
            visited.clear();
            bfs(searchStartNode);
            System.out.println(bfsResult.toString());
        }
    }


    static void dfs(int v) {
        if(visited.contains(v)) {
            return;
        }

        if (dfsResult.length() != 0) {
            dfsResult.append(" ");
        }
        dfsResult.append(v);
        visited.add(v);
        for (int i : linkedInfo[v]) {
            if(visited.contains(i)) {
                continue;
            }
            dfs(i);
        }
    }

    static void bfs(int searchStartNode) {
        Queue<Integer> bfsHistory = new LinkedList<>();

        visited.add(searchStartNode);
        bfsHistory.add(searchStartNode);

        while (!bfsHistory.isEmpty()) {
            Integer poll = bfsHistory.poll();
            if (dfsResult.length() != 0) {
                bfsResult.append(" ");
            }
            bfsResult.append(poll);
            for (int i : linkedInfo[poll]) {
                if(visited.contains(i)) {
                    continue;
                }
                visited.add(i);
                bfsHistory.add(i);
            }
        }
    }
}
