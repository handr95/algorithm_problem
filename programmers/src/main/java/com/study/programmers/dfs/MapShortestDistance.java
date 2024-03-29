package com.study.programmers.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 * 2단계
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * <p>
 * 문제 설명
 * ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
 * <p>
 * 지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
 * <p>
 * 10
 * 최단거리1_sxuruo.png
 * <p>
 * 위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다.
 * 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
 * 아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.
 * <p>
 * 첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.
 * 최단거리2_hnjd3b.png
 * <p>
 * 두 번째 방법은 15개의 칸을 지나서 상대팀 진영에 도착했습니다.
 * 최단거리3_ntxygd.png
 * <p>
 * 위 예시에서는 첫 번째 방법보다 더 빠르게 상대팀 진영에 도착하는 방법은 없으므로, 이 방법이 상대 팀 진영으로 가는 가장 빠른 방법입니다.
 * <p>
 * 만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다. 예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.
 * <p>
 * 최단거리4_of9xfg.png
 * <p>
 * 게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
 * <p>
 * 제한사항
 * maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
 * n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
 * maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
 * 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
 * <p>
 * 입출력 예
 * maps	answer
 * [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
 * [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
 * 입출력 예 설명
 * 입출력 예 #1
 * 주어진 데이터는 다음과 같습니다.
 * <p>
 * 최단거리6_lgjvrb.png
 * <p>
 * 캐릭터가 적 팀의 진영까지 이동하는 가장 빠른 길은 다음 그림과 같습니다.
 * <p>
 * 최단거리2_hnjd3b (1).png
 * <p>
 * 따라서 총 11칸을 캐릭터가 지나갔으므로 11을 return 하면 됩니다.
 * <p>
 * 입출력 예 #2
 * 문제의 예시와 같으며, 상대 팀 진영에 도달할 방법이 없습니다. 따라서 -1을 return 합니다.
 */
public class MapShortestDistance {

    public int mapShortestDistance(int[][] maps) {
        if (maps[0][0] == 0){
            return -1;
        }
        Queue<int[]> queue = new LinkedList();
        // 시작점이 되는 x, y 좌표 값
        queue.add(new int[]{0, 0});

        int maxX = maps.length;
        int maxY = maps[0].length;

        int[][] history = new int[maxX][maxY];
        history[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int x = head[0];
            int y = head[1];

            int goX = x + 1;
            int goY = y;
            if (goX < maxX && history[goX][goY] == 0 && maps[goX][goY] == 1) {
                queue.add(new int[]{goX, goY});
                history[goX][goY] = history[x][y] + 1;
            }

            goX = x;
            goY = y + 1;
            if (goY < maxY && history[goX][goY] == 0 && maps[goX][goY] == 1) {
                queue.add(new int[]{goX, goY});
                history[goX][goY] = history[x][y] + 1;
            }

            goX = x - 1;
            goY = y;
            if (goX >= 0 && history[goX][goY] == 0 && maps[goX][goY] == 1) {
                queue.add(new int[]{goX, goY});
                history[goX][goY] = history[x][y] + 1;
            }

            goX = x;
            goY = y - 1;
            if (goY >= 0 && history[goX][goY] == 0 && maps[goX][goY] == 1) {
                queue.add(new int[]{goX, goY});
                history[goX][goY] = history[x][y] + 1;
            }
        }

        return history[maxX - 1][maxY - 1] == 0 ? -1 : history[maxX - 1][maxY - 1];
    }

    /**
     * 문제 이해:
     * <p>
     * 이차원 배열 maps는 벽(0)과 길(1)로 이루어진 게임 맵을 나타냅니다.
     * 플레이어는 (1, 1)에서 출발하여 (n, m)인 상대팀 진영까지 이동해야 합니다.
     * 플레이어는 상하좌우로만 이동할 수 있으며, 벽은 통과할 수 없습니다.
     * <p>
     * 해결 방법:
     * <p>
     * BFS(Breadth-First Search) 알고리즘을 사용하여 상대팀 진영까지의 최단 거리를 계산합니다.
     * BFS는 시작 지점에서부터 한 단계씩 모든 가능한 방향으로 탐색하며 최단 거리를 찾는 알고리즘입니다.
     * 큐를 사용하여 BFS를 구현하며, 매 단계마다 상하좌우로 이동할 수 있는지 확인하여 탐색합니다.
     * <p>
     * 알고리즘 설명:
     * <p>
     * 시작 지점인 (1, 1)을 큐에 넣고, 거리를 1로 설정합니다.
     * 큐에서 꺼낸 위치에서 상하좌우로 이동할 수 있는지 확인합니다.
     * 이동할 수 있는 경우, 다음 위치와 거리를 큐에 넣습니다. 이때, 방문한 위치를 다시 방문하지 않도록 해당 위치를 0으로 표시합니다.
     * 큐가 빌 때까지 반복하며, 상대팀 진영에 도착하면 해당 거리를 반환합니다.
     * 만약 상대팀 진영에 도착할 수 없는 경우 -1을 반환합니다.
     * <p>
     * 코드 설명:
     * <p>
     * 코드는 주어진 문제를 해결하기 위해 BFS 알고리즘을 사용하여 상대팀 진영까지의 최단 거리를 계산합니다.
     * 각 위치에서 상하좌우로 이동하며 맵을 탐색하고, 이동할 수 있는 경우에는 다음 위치와 거리를 큐에 넣습니다.
     * 방문한 위치를 다시 방문하지 않도록 해당 위치를 0으로 표시하여 큐에 중복해서 추가되지 않도록 합니다.
     * BFS 탐색이 끝난 후에는 상대팀 진영까지의 최단 거리를 반환하며, 도달할 수 없는 경우 -1을 반환합니다.
     * <p>
     * 테스트 및 결과:
     * <p>
     * 코드는 주어진 맵에 대해 상대팀 진영까지의 최단 거리를 계산합니다.
     * 이를 통해 플레이어가 게임 맵에서 상대팀 진영까지 얼마나 빠르게 이동할 수 있는지를 확인할 수 있습니다.
     *
     * @param maps
     * @return
     */
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 방문 여부 및 최단 거리를 기록할 배열
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1); // 최단 거리를 -1로 초기화
        }

        // 상하좌우 이동을 위한 방향 배열
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 시작 위치에서의 최단 거리는 1
        distance[0][0] = 1;

        // BFS를 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 시작 위치 추가

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 이동 확인
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 다음 위치가 범위 내에 있고, 이동 가능하며, 아직 방문하지 않은 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1; // 최단 거리 갱신
                    queue.offer(new int[]{nx, ny}); // 다음 위치를 큐에 추가
                }
            }
        }

        // 상대팀 진영까지의 최단 거리 반환
        return distance[n - 1][m - 1];
    }
}
