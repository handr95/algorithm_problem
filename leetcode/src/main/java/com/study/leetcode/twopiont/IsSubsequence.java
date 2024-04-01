package com.study.leetcode.twopiont;

/**
 * 392. Is Subsequence
 * Easy
 * https://leetcode.com/problems/is-subsequence/
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        int sCharsIndex = 0;
        int tCharsIndex = 0;
        while(sCharsIndex < schars.length) {
            if (tCharsIndex == tchars.length) {
                return false;
            }

            int goal = schars[sCharsIndex];
            if (tchars[tCharsIndex] == goal) {
                sCharsIndex ++;
            }
            tCharsIndex ++;
        }
        return true;
    }
}
