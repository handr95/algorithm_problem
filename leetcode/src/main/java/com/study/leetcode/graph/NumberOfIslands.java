package com.study.leetcode.graph;

/**
 * 200. Number of Islands
 * Medium
 * https://leetcode.com/problems/number-of-islands
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 *  m == grid.length
 *  n == grid[i].length
 *  1 <= m, n <= 300
 *  grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

    public int numberOfIslands(char[][] grid) {
        int islandCnt = 0;
        for (int x = 0; x < grid.length; x ++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == '1') {
                    islandCnt++;
                    recursion(x, y, grid);
                }
            }
        }
        return islandCnt;
    }

    public void recursion(int x, int y, char[][] board) {
        if (board[x][y] == 'T') {
            return;
        }
        board[x][y] = 'T';
        int[][] directs = {{1,0},{0,1},{-1,0},{0,-1}};

        for (int[] direct : directs) {
            int goX = x + direct[0];
            int goY = y + direct[1];
            if (goX < 0 || goY < 0 || goX > board.length - 1 || goY > board[goX].length - 1) {
                continue;
            }

            if (board[goX][goY] == '1') {
                recursion(goX, goY, board);
                board[goX][goY] = 'T';
            }
        }
    }
}
