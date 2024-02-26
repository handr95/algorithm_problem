package com.study.leetcode.string;

/**
 * 6. Zigzag Conversion
 * Medium
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 *
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        char[] sChar = s.toCharArray();

        if (numRows == 1) {
            return s;
        }
        int startIdx = 0;
        boolean isDown = true;
        char[][] sCharConvert = new char[numRows][sChar.length/2 + 1];
        for (int i = 0; i < sChar.length; i ++) {
            if (startIdx == 0) {
                isDown = true;
            } else if (startIdx == numRows - 1) {
                isDown = false;
            }
            sCharConvert[startIdx][i/2] = sChar[i];
            startIdx += isDown ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (char[] convert: sCharConvert) {
            for (char c : convert) {
                if (c == 0) {
                    continue;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public String solution(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length())
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row == 0 || row == numRows - 1)
                goingDown = !goingDown;
            row += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder rowBuilder : rows) {
            result.append(rowBuilder);
        }

        return result.toString();
    }
}