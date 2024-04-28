package com.study.programmers.dfs;

import java.util.*;

/**
 * 석유 시추
 *
 * 문제 설명
 * [본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]
 *
 * 세로길이가 n 가로길이가 m인 격자 모양의 땅 속에서 석유가 발견되었습니다. 석유는 여러 덩어리로 나누어 묻혀있습니다. 당신이 시추관을 수직으로 단 하나만 뚫을 수 있을 때, 가장 많은 석유를 뽑을 수 있는 시추관의 위치를 찾으려고 합니다. 시추관은 열 하나를 관통하는 형태여야 하며, 열과 열 사이에 시추관을 뚫을 수 없습니다.
 *
 * 석유시추-1.drawio.png
 *
 * 예를 들어 가로가 8, 세로가 5인 격자 모양의 땅 속에 위 그림처럼 석유가 발견되었다고 가정하겠습니다. 상, 하, 좌, 우로 연결된 석유는 하나의 덩어리이며, 석유 덩어리의 크기는 덩어리에 포함된 칸의 수입니다. 그림에서 석유 덩어리의 크기는 왼쪽부터 8, 7, 2입니다.
 *
 * 석유시추-2.drawio.png
 *
 * 시추관은 위 그림처럼 설치한 위치 아래로 끝까지 뻗어나갑니다. 만약 시추관이 석유 덩어리의 일부를 지나면 해당 덩어리에 속한 모든 석유를 뽑을 수 있습니다. 시추관이 뽑을 수 있는 석유량은 시추관이 지나는 석유 덩어리들의 크기를 모두 합한 값입니다. 시추관을 설치한 위치에 따라 뽑을 수 있는 석유량은 다음과 같습니다.
 *
 * 시추관의 위치	획득한 덩어리	총 석유량
 * 1	[8]	8
 * 2	[8]	8
 * 3	[8]	8
 * 4	[7]	7
 * 5	[7]	7
 * 6	[7]	7
 * 7	[7, 2]	9
 * 8	[2]	2
 * 오른쪽 그림처럼 7번 열에 시추관을 설치하면 크기가 7, 2인 덩어리의 석유를 얻어 뽑을 수 있는 석유량이 9로 가장 많습니다.
 *
 * 석유가 묻힌 땅과 석유 덩어리를 나타내는 2차원 정수 배열 land가 매개변수로 주어집니다. 이때 시추관 하나를 설치해 뽑을 수 있는 가장 많은 석유량을 return 하도록 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ land의 길이 = 땅의 세로길이 = n ≤ 500
 * 1 ≤ land[i]의 길이 = 땅의 가로길이 = m ≤ 500
 * land[i][j]는 i+1행 j+1열 땅의 정보를 나타냅니다.
 * land[i][j]는 0 또는 1입니다.
 * land[i][j]가 0이면 빈 땅을, 1이면 석유가 있는 땅을 의미합니다.
 * 정확성 테스트 케이스 제한사항
 * 1 ≤ land의 길이 = 땅의 세로길이 = n ≤ 100
 * 1 ≤ land[i]의 길이 = 땅의 가로길이 = m ≤ 100
 * 효율성 테스트 케이스 제한사항
 * 주어진 조건 외 추가 제한사항 없습니다.
 * 입출력 예
 * land	result
 * [[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]	9
 * [[1, 0, 1, 0, 1, 1], [1, 0, 1, 0, 0, 0], [1, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0], [1, 0, 0, 1, 0, 1], [1, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1]]	16
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제의 예시와 같습니다.
 *
 * 입출력 예 #2
 *
 * 석유시추-3.drawio.png
 *
 * 시추관을 설치한 위치에 따라 뽑을 수 있는 석유는 다음과 같습니다.
 *
 * 시추관의 위치	획득한 덩어리	총 석유량
 * 1	[12]	12
 * 2	[12]	12
 * 3	[3, 12]	15
 * 4	[2, 12]	14
 * 5	[2, 12]	14
 * 6	[2, 1, 1, 12]	16
 * 6번 열에 시추관을 설치하면 크기가 2, 1, 1, 12인 덩어리의 석유를 얻어 뽑을 수 있는 석유량이 16으로 가장 많습니다. 따라서 16을 return 해야 합니다.
 *
 * 제한시간 안내
 *
 * 정확성 테스트 : 10초
 * 효율성 테스트 : 언어별로 작성된 정답 코드의 실행 시간의 적정 배수
 */
public class OilDrilling {

    public int solution(int[][] land) {
        int answer = 0;
        Map<Integer, Integer> areaMap = new HashMap<>();
        int areaStart = 100;

        for (int x = 0; x < land.length; x++) {
            for (int y = 0; y < land[0].length; y++) {
                if (land[x][y] == 1) {
                    //areaMap.put(areaStart, recursion(x, y, land, areaStart));
                    areaMap.put(areaStart, markArea(x, y, land, areaStart, land.length, land[0].length));
                    areaStart++;
                }
            }

        }

        for (int y = 0; y < land[0].length; y++) {
            Set<Integer> visited = new HashSet<>();
            int sum = 0;
            for (int x = 0; x < land.length; x++) {
                if (visited.add(land[x][y])) {
                    sum += areaMap.getOrDefault(land[x][y], 0);
                }
            }


            answer = Math.max(answer, sum);
        }
        return answer;
    }

    /**
     * 테스트 5 〉	실패 (런타임 에러)
     */
    public int recursion(int x, int y, int[][] land, int areaStart) {
        int sum = 1;
        if (land[x][y] != 1) {
            return 0;
        }
        land[x][y] = areaStart;

        int[][] directs = {{1,0},{0,1},{-1,0},{0,-1}};
        for (int[] direct : directs) {
            int goX = x + direct[0];
            int goY = y + direct[1];
            if (goX < 0 || goY < 0 || goX > land.length - 1 || goY > land[goX].length - 1) {
                continue;
            }

            if (land[goX][goY] == 1) {
                sum += recursion(goX, goY, land, areaStart);
            }
        }
        return sum;
    }

    private int markArea(int x, int y, int[][] land, int areaId, int rows, int cols) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        int count = 0;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int curX = pos[0];
            int curY = pos[1];

            if (curX < 0 || curY < 0 || curX >= rows || curY >= cols || land[curX][curY] != 1) {
                continue;
            }

            land[curX][curY] = areaId;
            count++;

            // Add all adjacent cells to the stack
            stack.push(new int[]{curX + 1, curY});
            stack.push(new int[]{curX - 1, curY});
            stack.push(new int[]{curX, curY + 1});
            stack.push(new int[]{curX, curY - 1});
        }

        return count;
    }
}
