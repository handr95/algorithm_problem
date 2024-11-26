package com.study.leetcode.string;

/**
 * 3110. Score of a String
 * Easy
 * https://leetcode.com/problems/score-of-a-string
 *
 * You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
 *
 * Return the score of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 *
 * Output: 13
 *
 * Explanation:
 *
 * The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111.
 * So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
 *
 * Example 2:
 *
 * Input: s = "zaz"
 *
 * Output: 50
 *
 * Explanation:
 *
 * The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.
 *
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 100
 * s consists only of lowercase English letters.
 */
public class ScoreOfString {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int cur = s.charAt(i);
            int next = s.charAt(i + 1);
            int temp = cur - next;
            if (temp < 0) {
                sum += temp * -1;
            } else {
                sum += temp;
            }
        }
        return sum;
    }

    public int scoreOfStringUsingMath(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return sum;
    }
}
