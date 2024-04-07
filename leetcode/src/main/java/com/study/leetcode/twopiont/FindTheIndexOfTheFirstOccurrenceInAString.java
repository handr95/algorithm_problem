package com.study.leetcode.twopiont;


/**
 * 28. Find the Index of the First Occurrence in a String
 * Easy
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int findTheIndexOfTheFirstOccurrenceInAString(String haystack, String needle){
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        if(haystacks.length < needles.length) {
            return -1;
        }

        for (int startIdx = 0; startIdx <= haystacks.length - needles.length; startIdx++) {
            int finishIdx;
            for (finishIdx = 0; finishIdx < needles.length; finishIdx++) {
                if (haystacks[startIdx + finishIdx] != needles[finishIdx]) {
                    break;
                }
            }
            if (finishIdx == needles.length) {
                return startIdx;
            }
        }

        return -1;
    }

    public int simple(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
