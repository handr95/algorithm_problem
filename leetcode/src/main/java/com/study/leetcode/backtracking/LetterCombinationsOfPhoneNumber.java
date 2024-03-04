package com.study.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * Medium
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfPhoneNumber {
    static Map<Integer, String[]> phoneDigit = new HashMap<>();
    static {
        phoneDigit.put(2, new String[]{"a", "b", "c"});
        phoneDigit.put(3, new String[]{"d", "e", "f"});
        phoneDigit.put(4, new String[]{"g", "h", "i"});
        phoneDigit.put(5, new String[]{"j", "k", "l"});
        phoneDigit.put(6, new String[]{"m", "n", "o"});
        phoneDigit.put(7, new String[]{"p", "q", "r", "s"});
        phoneDigit.put(8, new String[]{"t", "u", "v"});
        phoneDigit.put(9, new String[]{"w", "x", "y", "z"});
    }

    /**
     *
     이 문제는 전형적인 조합(Combination) 문제로, 재귀(recursion)를 사용하여 해결할 수 있습니다. 각 숫자에 대해 가능한 문자들을 매핑해놓고, 이를 조합하여 결과를 생성합니다. 주어진 숫자 문자열을 순회하면서 각 숫자에 해당하는 문자들을 조합해가며 결과를 생성하면 됩니다.

     여기 몇 가지 힌트가 있습니다:

     숫자에 대응하는 문자 매핑을 딕셔너리로 정의합니다. 예를 들어, {'2': ['a', 'b', 'c'], '3': ['d', 'e', 'f'], ...}와 같이 정의할 수 있습니다.

     재귀 함수를 작성합니다. 이 함수는 현재까지 빌드된 문자열과 다음 숫자의 인덱스를 인자로 받습니다.

     재귀 호출 시에는 현재까지 빌드된 문자열에 숫자에 해당하는 각 문자를 추가해가면서 호출합니다.

     재귀 호출이 끝나는 조건은 현재까지 빌드된 문자열의 길이가 주어진 숫자 문자열의 길이와 같을 때입니다.
     */
    public void recursion(int depth, int[] digits, StringBuilder combine, List<String> combineLetter) {
        if (depth == digits.length) {
            combineLetter.add(combine.toString());
            return;
        }
        int number = digits[depth];
        String[] strings = phoneDigit.get(number);
        for (int i = 0; i < strings.length; i ++) {
            combine.setLength(depth);
            combine.append(strings[i]);
            recursion(depth + 1, digits, new StringBuilder(combine), combineLetter);
        }
    }


    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        char[] digitArray = digits.toCharArray();
        int[] digitNumbers = new int[digitArray.length];
        for (int i = 0; i < digitArray.length; i++) {
            digitNumbers[i] = digitArray[i] - '0';
        }
        List<String> result  = new ArrayList<>();
        recursion(0, digitNumbers,  new StringBuilder(), result);

        return result;
    }


    public List<String> solution(String digits) {
        // 결과를 저장할 리스트
        List<String> result = new ArrayList<>();

        // 주어진 숫자 문자열이 비어있는 경우 빈 리스트를 반환
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 각 숫자에 대한 문자 매핑을 정의한 맵
        Map<Character, String> digitMap = new HashMap<>();
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");

        // 재귀 호출을 통해 문자 조합 생성
        generateCombinations(digits, digitMap, 0, new StringBuilder(), result);

        return result;
    }

    private void generateCombinations(String digits, Map<Character, String> digitMap, int index, StringBuilder current, List<String> result) {
        // 기저 사례: index가 숫자 문자열의 길이와 같은 경우
        if (index == digits.length()) {
            result.add(current.toString()); // 현재까지 생성된 문자열을 결과 리스트에 추가
            return;
        }

        // 현재 숫자에 대한 문자들을 가져옴
        String letters = digitMap.get(digits.charAt(index));

        // 현재 숫자의 각 문자를 반복하면서 재귀 호출
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i)); // 현재 문자를 문자열에 추가
            generateCombinations(digits, digitMap, index + 1, current, result); // 다음 숫자로 재귀 호출
            current.deleteCharAt(current.length() - 1); // 추가했던 문자를 다시 제거하여 백트래킹
        }
    }
}
