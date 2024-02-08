package com.study.programmers.greedy;

/**
 * 조이 스틱
 * 2단계
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 *
 * 문제 설명
 * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
 *
 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
 *  ▲ - 다음 알파벳
 *  ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 *  ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 *  ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
 * 예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
 *
 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
 * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
 *
 * 제한 사항
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 *
 * 입출력 예
 * name 	    return
 * "JEROEN"	    56
 * "JAN"	    23
 */
public class JoyStick {
    public int joystick(String name) {
        int answer = 0;
        int length = name.length();

        // 알파벳을 변경하는 횟수 계산
        for (int i = 0; i < length; i++) {
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);
        }

        /**
         * TAATAAAAAT
         * 1. 한쪽 방향으로만 가는 방법 : 7 + A + A + T + 7 + A + A + A + A + A + 7
         * 2. 연속되는 A의 첫시작점(오)까지 갔다가 마지막 지점(왼)으로 되돌아 가는 방법 : 7 + A + A + T + 7 + A + A + T + T + 7
         * 3. 연속되는 A의 마지막점(왼)까지 되돌아 갔다가 첫번째 지점(오)으로 가는 가는 방법 : T + 7 + T + 7 + A + A + T + 7
         *
         * 세방식의 거리를 비교하여 가장 빠른 길을 찾음 (A에서 원하는 알파벳(A -> T)으로 가는 횟수는 세방식 모두 동일하므로 위에서 한번만 계산하도록함.)
         */
        // 커서 이동 횟수 계산
        int minMove = length - 1; // 초기값: 모든 문자를 오른쪽으로 이동하는 경우
        int startIdx = -1;  // 연속되는 A의 시작 지점
        int endIdx = -1;    // 연속되는 A의 마지막 지점
        for (int i = 0; i < length; i++) {
            int index = i + 1;
            while (index < length && name.charAt(index) == 'A') {
                index ++;
            }

            startIdx = i;
            endIdx = index;

            int r = (startIdx * 2) + length - endIdx;
            int l = (length - endIdx) * 2 + startIdx;
            if (minMove > r ) {
                minMove = r;
            }
            if (minMove > l ) {
                minMove = l;
            }
        }

        // 알파벳 변경 횟수와 커서 이동 횟수 합산하여 최종 결과 반환
        answer += minMove;

        return answer;
    }

    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        // 알파벳을 변경하는 횟수 계산
        for (int i = 0; i < length; i++) {
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);
        }

        // 커서 이동 횟수 계산
        int minMove = length - 1; // 초기값: 모든 문자를 오른쪽으로 이동하는 경우
        for (int i = 0; i < length; i++) {
            // 연속된 A의 길이 계산
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            int move = i + length - next + Math.min(i, length - next);
            minMove = Math.min(minMove, move);
        }

        // 알파벳 변경 횟수와 커서 이동 횟수 합산하여 최종 결과 반환
        answer += minMove;

        return answer;
    }
}