package com.study.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 13023번. ABCDE
 * https://www.acmicpc.net/problem/13023
 * 난이도 : 골드 5
 *
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 * 2 초	512 MB	52011	16497	10952	28.776%
 *
 * 문제
 * BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
 * 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
 *
 * A는 B와 친구다.
 * B는 C와 친구다.
 * C는 D와 친구다.
 * D는 E와 친구다.
 * 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
 *
 * 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며,
 * a와 b가 친구라는 뜻이다.
 * (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
 *
 * 출력
 * 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
 * <p>
 * 예제 입력 1
 * 5 4
 * 0 1
 * 1 2
 * 2 3
 * 3 4
 * 예제 출력 1
 * 1
 * ====
 * 예제 입력 2
 * 5 5
 * 0 1
 * 1 2
 * 2 3
 * 3 0
 * 1 4
 * 예제 출력 2
 * 1
 * ====
 * 예제 입력 3
 * 6 5
 * 0 1
 * 0 2
 * 0 3
 * 0 4
 * 0 5
 * 예제 출력 3
 * 0
 * ====
 * 예제 입력 4
 * 8 8
 * 1 7
 * 3 7
 * 4 7
 * 3 4
 * 4 6
 * 3 5
 * 0 4
 * 2 7
 * 예제 출력 4
 * 1
 */
public class FindFriendship {

    static int NEED_DEPTH = 4;
    static Map<Integer, List<Integer>> relationList = new HashMap<>();

    public static void findFriendship() throws IOException {
        relationList = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int friendQty = Integer.parseInt(st.nextToken());   // 사람의 수
            int relationshipQty = Integer.parseInt(st.nextToken());   // 친구 관계
            for (int i = 0; i < relationshipQty; i++) {
                st = new StringTokenizer(br.readLine());
                int friend1 = Integer.parseInt(st.nextToken());   // 친구 1
                int friend2 = Integer.parseInt(st.nextToken());   // 친구 2

                List<Integer> friend1Relation = relationList.getOrDefault(friend1, new ArrayList<>());
                friend1Relation.add(friend2);
                List<Integer> friend2Relation = relationList.getOrDefault(friend2, new ArrayList<>());
                friend2Relation.add(friend1);

                relationList.put(friend1, friend1Relation);
                relationList.put(friend2, friend2Relation);
            }

            for (Integer friend : relationList.keySet()) {
                int[] visited = new int[friendQty];
                if (findRelation(visited, friend, 0)) {
                    System.out.println(1);
                    return;
                }
            }
            System.out.println(0);
        }
    }

    public static boolean findRelation(int[] visited, int friend, int depth) {
        if (visited[friend] == 1) {
            return false;
        }
        if (depth == NEED_DEPTH) {
            return true;
        }

        visited[friend] = 1;
        List<Integer> relations = relationList.getOrDefault(friend, new ArrayList<>());
        for (Integer relation : relations) {
            if (findRelation(visited, relation, depth + 1)) {
                return true;
            }
        }


        visited[friend] = 0;
        return false;
    }
}
