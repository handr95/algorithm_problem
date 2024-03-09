package com.study.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 151. 문자열의 단어 바꾸기
 * Medium
 * https://leetcode.com/problems/reverse-words-in-a-string/description
 *
 * 입력 문자열 s가 주어졌을 때, 단어의 순서를 반대로 합니다.
 *
 * 단어는 공백이 아닌 문자의 시퀀스로 정의됩니다. s의 단어는 적어도 하나의 공백으로 구분됩니다.
 *
 * 하나의 공백으로 연결된 역순의 단어 문자열을 반환합니다.
 *
 * s에는 선행 또는 후행 공백이 포함되거나 두 단어 사이에 여러 개의 공백이 포함될 수 있습니다. 반환된 문자열에는 단어를 구분하는 공백이 하나만 있어야 합니다. 여분의 공백은 포함하지 마세요.
 *
 *
 *
 * 예제 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * 예 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * 설명: 반전된 문자열에는 선행 또는 후행 공백이 포함되어서는 안 됩니다.
 * 예 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * 설명: 반전된 문자열에서 두 단어 사이의 여러 공백을 하나의 공백으로 줄여야 합니다.
 *
 *
 * 제약 조건:
 *
 * 1 <= s.length <= 104
 * s에는 영어 문자(대문자 및 소문자), 숫자 및 공백 ' ' 이 포함됩니다.
 * s에 단어가 하나 이상 포함되어야 합니다.
 *
 *
 * 후속 조치: 사용 중인 언어에서 문자열 데이터 유형이 변경 가능한 경우 O(1)의 추가 공백을 사용하여 제자리에서 해결할 수 있나요?
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();


        boolean isSpace = true;
        StringBuilder temp = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i --) {
            if (isSpace && chars[i] == ' ') {
                continue;
            }
            if (chars[i] == ' ') {
                if(!sb.isEmpty() && !isSpace) {
                    sb.append(" ");
                }
                sb.append(temp.reverse());
                temp = new StringBuilder();
                isSpace = true;
            } else {
                temp.append(chars[i]);
                isSpace = false;
            }
        }
        if (!temp.isEmpty()) {
            sb.append(" ");
            sb.append(temp.reverse());
        }

        return sb.toString();
    }


    /*public String reverseWordsUsingLambdaUnder17(String s) {
        return Arrays.asList(s.split(" ")).reversed().stream().filter(e -> !e.equals("")).collect(Collectors.joining(" "));
    }*/

    public String reverseWordsUsingLambda17(String s) {
        return Arrays.stream(s.split(" "))
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
                    Collections.reverse(lst);
                    return lst;
                }))
                .stream()
                .collect(Collectors.joining(" "));
    }

    public String solution(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }
}
