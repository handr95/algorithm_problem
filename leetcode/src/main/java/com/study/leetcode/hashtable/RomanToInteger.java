package com.study.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Easy
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * 로마 숫자는 일반적으로 왼쪽에서 오른쪽으로 가장 큰 숫자부터 가장 작은 숫자로 기록됩니다. 그러나 4의 숫자는 IIII이 아닙니다. 대신 숫자 4는 IV로 쓰여집니다. 1이 5보다 앞에 있기 때문에 그것을 빼면 4가 됩니다. IX로 쓰여진 숫자 9에도 동일한 원칙이 적용됩니다. 뺄셈이 사용되는 경우는 6가지가 있습니다.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {

    /**
     * hashtable을 이용하여 로마 문자를 정수로 치환
     * @param s 로마 문자
     * @return 정수
     */
    public int romanToInt(String s) {
        Map<String, Integer> romanChars = new HashMap<>();
        romanChars.put("I", 1);
        romanChars.put("V", 5);
        romanChars.put("X", 10);
        romanChars.put("L", 50);
        romanChars.put("C", 100);
        romanChars.put("D", 500);
        romanChars.put("M", 1000);

        char[] charArray = s.toCharArray();
        int result = 0;
        int temp = 0;
        for (char roman : charArray) {
            String romanStr = String.valueOf(roman);
            if (convertRomanCheck(temp, romanStr)) {
                result += romanChars.getOrDefault(romanStr, 0) - temp;
                temp = 0;
                continue;
            } else {
                result += temp;
            }

            temp = 0;
            if(romanStr.equals("I")) {
                temp += 1;
            } else if (romanStr.equals("X")) {
                temp += 10;
            } else if (romanStr.equals("C")) {
                temp += 100;
            } else {
                result += romanChars.getOrDefault(romanStr, 0);
            }
        }

        result += temp;
        return result;
    }

    public boolean convertRomanCheck(final int temp, final String romanStr) {
        if (temp == 1 && (romanStr.equals("V") || romanStr.equals("X"))) {
            return true;
        } else if (temp == 10 && (romanStr.equals("L") || romanStr.equals("C"))) {
            return true;
        } else return temp == 100 && (romanStr.equals("D") || romanStr.equals("M"));
    }

    /**
     * hashtable을 이용하여 로마 문자를 정수로 치환
     * @param s 로마 문자
     * @return 정수
     */
    public int romanToIntSolution(String s) {
        Map<Character, Integer> m = new HashMap<>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }
}