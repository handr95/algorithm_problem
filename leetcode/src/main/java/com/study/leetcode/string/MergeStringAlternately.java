package com.study.leetcode.string;

/**
 * 1768. Merge Strings Alternately
 * Easy
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * word1과 word2라는 두 개의 문자열이 주어집니다. word1부터 시작하여 문자를 번갈아 가며 추가하여 문자열을 병합합니다. 한 문자열이 다른 문자열보다 길면 병합된 문자열의 끝에 추가 문자를 추가합니다.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
public class MergeStringAlternately {
    public String mergeAlternately(String word1, String word2) {
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();

        int index1 = 0;
        int index2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean revers = false;
        while (index1 < words1.length || index2 < words2.length) {
            if (index1 == word1.length()){
                stringBuilder.append(words2[index2]);
                index2++;
                continue;
            } else if (index2 == word2.length()) {
                stringBuilder.append(words1[index1]);
                index1++;
                continue;
            }

            if (revers) {
                stringBuilder.append(words2[index2]);
                index2++;
                revers = false;
            } else {
                stringBuilder.append(words1[index1]);
                index1++;
                revers = true;
            }
        }
        return stringBuilder.toString();
    }

    public String solution(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}
