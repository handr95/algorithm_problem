package com.study.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 11724. 연결 요소의 개수
 * 시간 제한 : 3초
 * 난이도 : 실버 2
 * https://www.acmicpc.net/problem/11724
 * <p>
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력:
 * 첫째 줄에 노드의 개수 N과 에지의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
 * 둘째 줄부터 M개의 줄에 에지의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 에지은 한 번만 주어진다.
 * <p>
 * 출력:
 * 첫째 줄에 연결 요소의 개수를 출력한다.
 * <p>
 * 예제1:
 * 입력
 * 6 5
 * 1 2
 * 2 5
 * 5 1
 * 3 4
 * 4 6
 * <p>
 * 출력
 * 2
 * <p>
 * 예제2:
 * 입력
 * 6 8
 * 1 2
 * 2 5
 * 5 1
 * 3 4
 * 4 6
 * 5 4
 * 2 4
 * 2 3
 * <p>
 * 출력
 * 1
 */
public class CountingConnectedComponent {
    static ArrayList<Integer>[] linkedInfo;
    static boolean[] visited;

    public static void countingConnectedComponent() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeQty = Integer.parseInt(st.nextToken());   // 노드의 개수
            int edgeQty = Integer.parseInt(st.nextToken());   // 에지의 개수

            linkedInfo = new ArrayList[nodeQty + 1];
            visited = new boolean[nodeQty + 1];

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
            int count = 0;
            for (int i = 1; i < nodeQty + 1; i++) {
                if (!visited[i]) {
                    count++;
                    recursion(i);
                }
            }
            System.out.println(count);
        }
    }

    static void recursion(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : linkedInfo[v]) {
            if (visited[i]) {
                continue;
            }
            recursion(i);
        }
    }
}
