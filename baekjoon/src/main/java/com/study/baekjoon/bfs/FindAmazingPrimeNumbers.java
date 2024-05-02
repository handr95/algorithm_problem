package com.study.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2023번. 신기한 소수
 * https://www.acmicpc.net/problem/2023
 * 난이도 : 골드 5
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 * 2 초	4 MB	23636	11449	8076	45.884%
 *
 * <p>
 * 문제
 * 수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.
 * <p>
 * 7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다.
 * 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
 * <p>
 * 수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.
 * <p>
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
 * <p>
 * 출력
 * N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
 * <p>
 * 예제 입력 1
 * 4
 * <p>
 * 예제 출력 1
 * 2333
 * 2339
 * 2393
 * 2399
 * 2939
 * 3119
 * 3137
 * 3733
 * 3739
 * 3793
 * 3797
 * 5939
 * 7193
 * 7331
 * 7333
 * 7393
 */
public class FindAmazingPrimeNumbers {
    static int digit = 0;
    public static void findAmazingPrimeNumbers() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            digit = Integer.parseInt(st.nextToken());   // 자리수
            DFS(2, 1);
            DFS(3, 1);
            DFS(5, 1);
            DFS(7, 1);
        }
    }

    public static boolean DFS(int num, int curDigit) {
        if (digit <= curDigit && isPrime(num)) {
            System.out.println(num);
            return true;
        }

        if (isPrime(num) == false) {
            return false;
        }

        int pow = 10;
        curDigit++;

        DFS(num * pow + 1, curDigit);
        DFS(num * pow + 3, curDigit);
        DFS(num * pow + 5, curDigit);
        DFS(num * pow + 7, curDigit);
        DFS(num * pow + 9, curDigit);

        return true;
    }

    public static boolean isPrime(int num) {
        int sqrtNum = (int) Math.sqrt(num); // 제곱근을 정수로 변환
        for (int i = 2; i <= sqrtNum; i++) {
            if (num % i == 0) {
                return false; // 나누어 떨어지면 합성수
            }
        }
        return true; // 나누어 떨어지지 않으면 소수
    }
}
