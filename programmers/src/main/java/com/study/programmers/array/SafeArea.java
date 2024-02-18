package com.study.programmers.array;

/**
 * 안전 지대
 * 1단계
 * https://school.programmers.co.kr/learn/courses/30/lessons/120866
 * <p>
 * 문제 설명
 * 다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
 * image.png
 * 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
 * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * board는 n * n 배열입니다.
 * 1 ≤ n ≤ 100
 * 지뢰는 1로 표시되어 있습니다.
 * board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
 * <p>
 * 입출력 예
 * board	result
 * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]	16
 * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	13
 * [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0
 * 입출력 예 설명
 * 입출력 예 #1
 * <p>
 * (3, 2)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선 총 8칸은 위험지역입니다. 따라서 16을 return합니다.
 * 입출력 예 #2
 * <p>
 * (3, 2), (3, 3)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선은 위험지역입니다. 따라서 위험지역을 제외한 칸 수 13을 return합니다.
 * 입출력 예 #3
 * <p>
 * 모든 지역에 지뢰가 있으므로 안전지역은 없습니다. 따라서 0을 return합니다.
 */
public class SafeArea {
    public int solution(int[][] board) {
        int[][] filterBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    setDangerArea(i, j, filterBoard);
                }
            }
        }

        int safeAreaCnt = 0;
        for (int[] row : filterBoard) {
            for (int factor : row) {
                if (factor == 0) {
                    safeAreaCnt++;
                }
            }
        }

        return safeAreaCnt;
    }

    /**
     * (0,0), (0,1), (0,2)
     * (1,0), (1,1), (1,2)
     * (2,0), (2,1), (2,2)
     * <p>
     * 위험 구간 세팅
     *
     * @param filterBoard 맵 정보
     * @param x 지뢰 1차원 배열 위치
     * @param y 지뢰 2차원 배열 위치
     */
    public void setDangerArea(int x, int y, int[][] filterBoard) {
        int[][] directList = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int maxX = filterBoard.length;
        int maxy = filterBoard[0].length;
        filterBoard[x][y] = -1;

        for(int[] direct : directList) {
            int goX = direct[0] + x;
            int goy = direct[1] + y;

            if (goX < 0 || goy < 0 || goX >= maxX || goy >= maxy) {
                continue;
            }
            filterBoard[goX][goy] = -1;
        }
    }
}