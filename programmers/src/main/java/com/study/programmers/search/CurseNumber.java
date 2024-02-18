package com.study.programmers.search;

/**
 * 저주의 숫자3
 * 0단계
 * https://school.programmers.co.kr/learn/courses/30/lessons/120871
 *
 * <p>
 * 문제 설명
 * 3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다. 3x 마을 사람들의 숫자는 다음과 같습니다.
 * <p>
 * 10진법	3x 마을에서 쓰는 숫자
 * 1	1
 * 2	2
 * 3	4
 * 4	5
 * 5	7
 * 6	8
 * 7	10
 * 8	11
 * 9	14
 * 10	16
 * 정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.
 * <p>
 * <p>
 * 제한사항
 * 1 ≤ n ≤ 100
 * <p>
 * 입출력 예
 * n	result
 * 15	25
 * 40	76
 * <p>
 * 입출력 예 설명
 * 입출력 예 #1
 * <p>
 * 15를 3x 마을의 숫자로 변환하면 25입니다.
 * <p>
 * 입출력 예 #2
 * <p>
 * 40을 3x 마을의 숫자로 변환하면 76입니다.
 */
public class CurseNumber {
    public int solution(int n) {
        int index = 0;
        for (int i = 1; i <= n; i++) {
            index++;

            String parseIndex = String.valueOf(index);
            while (index % 3 == 0 || parseIndex.contains("3")) {
                index ++;
                parseIndex = String.valueOf(index);
            }
        }

        return index;
    }
}
