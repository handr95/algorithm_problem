package com.study.leetcode.graph;


/**
 *  130. Surrounded Regions
 *  Medium
 *  https://leetcode.com/problems/surrounded-regions
 *
 *  Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *  A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 *  Example 1:
 *      Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 *      Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 *      Explanation: Notice that an 'O' should not be flipped if:
 *      - It is on the border, or
 *      - It is adjacent to an 'O' that should not be flipped.
 *      The bottom 'O' is on the border, so it is not flipped.
 *      The other three 'O' form a surrounded region, so they are flipped.
 *
 *  Example 2:
 *      Input: board = [["X"]]
 *      Output: [["X"]]
 *
 *
 *  Constraints:
 *      m == board.length
 *      n == board[i].length
 *      1 <= m, n <= 200
 *      board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegions {
    public void surroundedRegions(char[][] board) {
        // 테두리에 있는 O 검색
        for (int x = 0; x < board.length; x ++) {
            for (int y = 0; y < board[x].length; y++) {
                if (x != 0 && x != board.length - 1 && y != 0 && y != board[x].length - 1) {
                    continue;
                }
                if (board[x][y] == 'O') {
                    recursion(x, y, board);
                    board[x][y] = 'T';
                }
            }
        }

        // x로 둘러쌓여 있는 O. X로 변경 처리
        for (int x = 0; x < board.length; x ++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 'T') {
                    board[x][y] = 'O';
                } else if (board[x][y] == 'O') {
                    board[x][y] = 'X';
                }
            }
        }
    }

    public void recursion(int x, int y, char[][] board) {
        int[][] directs = {{1,0},{0,1},{-1,0},{0,-1}};

        for (int[] direct : directs) {
            int goX = x + direct[0];
            int goY = y + direct[1];
            if (goX < 0 || goY < 0 || goX > board.length - 1 || goY > board[goX].length - 1) {
                continue;
            }

            if (board[goX][goY] == 'O') {
                board[goX][goY] = 'T';
                recursion(goX, goY, board);
            }
        }
    }
}
