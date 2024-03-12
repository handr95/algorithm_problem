package com.study.leetcode.hashtable;

import java.util.*;

/**
 * 1657. Determine if Two Strings Are Close
 * Medium
 * https://leetcode.com/problems/determine-if-two-strings-are-close
 *
 * 다음 연산을 사용하여 다른 문자열에서 하나를 얻을 수 있는 경우 두 문자열은 가까운 것으로 간주됩니다:
 *
 * 연산 1: 기존 문자 두 개를 바꿉니다.
 *  예: abcde -> aecdb
 *
 * 연산 2: 한 기존 문자의 모든 항목을 다른 기존 문자로 변환하고 다른 문자에 대해서도 동일한 작업을 수행합니다.
 *  예: aacabb -> bbcbaa(모든 a는 b로, 모든 b는 a로 바뀜)
 * 두 문자열 모두 필요한 횟수만큼 연산을 사용할 수 있습니다.
 *
 * 두 개의 문자열, 단어1과 단어2가 주어지면 단어1과 단어2가 가까우면 참을 반환하고, 그렇지 않으면 거짓을 반환합니다.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 *
 * Example 2:
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 *
 * Example 3:
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *  1 <= word1.length, word2.length <= 105
 *  word1 and word2 contain only lowercase English letters.
 */
public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();
        if (words1.length != words2.length) {
            return false;
        }

        // 1번째 : 두개의 문자의 위치를 변경함
        // 2번재 : 한 기존 문자의 모든 항목을 다른 기존 문자로 변환하고 다른 문자에 대해서도 동일한 작업을 수행합니다.

        //동일한 문자가 포함되어 있고, 문자(동일 문자가 아니여도됨.)의 빈도만 동일하면됨.
        Map<Integer, Integer> word1LetterCnt = new HashMap<>();
        for (char w : words1) {
            word1LetterCnt.put((int)w, word1LetterCnt.getOrDefault((int)w, 0) + 1);
        }
        Map<Integer, Integer> word2LetterCnt = new HashMap<>();
        for (char w : words2) {
            word2LetterCnt.put((int)w, word2LetterCnt.getOrDefault((int)w, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : word1LetterCnt.entrySet()) {
            if (word2LetterCnt.get(entry.getKey()) == null) {
                return false;
            }
        }

        for (Map.Entry<Integer, Integer> entry : word1LetterCnt.entrySet()) {
            if (word2LetterCnt.get(entry.getKey()) == null) {
                return false;
            }
        }

        for (Integer frequency : word2LetterCnt.values()) {
            boolean pass = false;
            for (Map.Entry<Integer, Integer> entry : word1LetterCnt.entrySet()) {
                if (entry.getValue().equals(frequency)) {
                    word1LetterCnt.put(entry.getKey(), 0);
                    pass = true;
                    break;
                }
            }
            if (!pass) {
                return false;
            }
        }

        return true;
    }
}
