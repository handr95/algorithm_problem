package com.study.programmers.sort;


import java.util.Arrays;

/**
 * 문자열 내림차순으로 배치하기
 * 1단계
 * https://school.programmers.co.kr/learn/courses/30/lessons/12917
 *
 * 문제 설명
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 *
 * 제한 사항
 * str은 길이 1 이상인 문자열입니다.
 * 입출력 예
 * s	return
 * "Zbcdefg"	"gfedcbZ"
 */
public class StringDesc {
    public String stringDesc(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length - 1; i ++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] < charArray[j]) {
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }

        StringBuilder buffer = new StringBuilder();
        for (char ch : charArray) {
            buffer.append(ch);
        }

        return buffer.toString();
    }

    public String solution(String str){
        char[] sol = str.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }
}
