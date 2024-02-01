package com.study.leetcode.hashtable;


import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters Solved
 * Medium
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] sArray = s.toCharArray();
        Queue<String> stringQueue = new LinkedList();
        for (char sChar : sArray) {
            String parseChar = String.valueOf(sChar);
            if (stringQueue.contains(parseChar)) {
                if (stringQueue.size() > result) {
                    result = stringQueue.size();
                }
                while (!parseChar.equals(stringQueue.poll())) {
                }
            }
            stringQueue.offer(parseChar);
        }

        return result < stringQueue.size() ? stringQueue.size() : result;
    }

    /**
     * 접근 방식 1 - 집합
     * 1. 현재 부분 문자열의 고유 문자를 추적하기 위해 집합(charSet)을 사용합니다.
     * 2. 현재 부분 문자열의 경계를 나타내기 위해 왼쪽과 오른쪽에 두 개의 포인터를 유지합니다.
     * 3. maxLength 변수는 지금까지 발견된 가장 긴 부분 문자열의 길이를 추적합니다.
     * 4. 오른쪽 포인터를 사용하여 문자열을 반복합니다.
     * 5. 현재 문자가 집합(charSet)에 없으면 새로운 고유 문자가 있다는 뜻입니다.
     * 6. 문자를 집합에 삽입하고 필요한 경우 최대 길이를 업데이트합니다.
     * 7. 문자가 이미 집합에 있는 경우 현재 하위 문자열 내에서 반복되는 문자를 나타냅니다.
     * 8. 이 경우 왼쪽 포인터를 앞으로 이동하여 반복되는 문자가 더 이상 존재하지 않을 때까지 집합에서 문자를 제거합니다.
     * 9. 현재 문자를 집합에 삽입하고 반복을 계속합니다.
     * 10. 마지막으로 반복되는 문자가 없는 가장 긴 부분 문자열의 길이로 maxLength를 반환합니다.
     * @param s
     * @return
     */
    public int solution1(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }

    /**
     * 접근 방식 2 - 정렬되지 않은 맵
     * 1. 첫 번째 솔루션을 개선하여 집합 대신 정렬되지 않은 맵(charMap)을 사용합니다.
     * 2. 이 맵은 문자를 키로, 인덱스를 값으로 저장합니다.
     * 3. 왼쪽과 오른쪽 포인터와 maxLength 변수는 그대로 유지합니다.
     * 4. 오른쪽 포인터를 사용해 문자열을 반복합니다.
     * 5. 현재 문자가 맵에 없거나 인덱스가 왼쪽보다 작으면 새로운 고유 문자라는 뜻입니다.
     *   6 문자의 인덱스로 charMap을 업데이트하고 필요한 경우 maxLength를 업데이트합니다.
     * 6. 문자가 현재 하위 문자열 내에서 반복되는 경우 왼쪽 포인터를 문자의 마지막 발생 후 다음 위치로 이동합니다.
     * 7. charMap에서 현재 문자의 인덱스를 업데이트하고 반복을 계속합니다.
     * 8. 마지막에는 반복되는 문자가 없는 가장 긴 부분 문자열의 길이로 maxLength를 반환합니다.
     *
     * @param s The input string
     * @return The length of the longest substring without repeating characters
     */
    public int solution2(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }

        return maxLength;
    }

    /**
     * 접근 방식 3 - 정수 배열
     * 1. 이 솔루션은 문자 인덱스를 저장하기 위해 정수 배열 charIndex를 사용합니다.
     * 2. 배열을 활용하면 정렬되지 않은 맵이 필요하지 않습니다.
     * 3. 최대 길이, 왼쪽 및 오른쪽 포인터는 여전히 존재합니다.
     * 4. 오른쪽 포인터를 사용하여 문자열을 반복합니다.
     * 5. 현재 하위 문자열 내에서 현재 문자가 발생했는지 charIndex의 인덱스를 왼쪽과 비교하여 확인합니다.
     * 6. 문자가 발생하면 왼쪽 포인터를 문자가 마지막으로 발생한 후 다음 위치로 이동합니다.
     * 7. 현재 문자의 인덱스를 charIndex에서 업데이트합니다.
     * 8. 각 단계마다 현재 하위 문자열의 길이를 계산하여 maxLength를 업데이트합니다.
     * 9. 문자열의 끝에 도달할 때까지 반복을 계속합니다.
     * 10. 마지막으로 반복되는 문자가 없는 가장 긴 부분 문자열의 길이로 maxLength를 반환합니다.
     *
     * @param s
     * @return
     */
    public int solution3(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
