package com.study.programmers.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 햄버거 만들기
 * 1단계
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * <p>
 * 문제 설명
 * 햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,
 * 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다.
 * 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
 * <p>
 * 예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때,
 * 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
 * <p>
 * 상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
 * <p>
 * 제한사항
 * 1 ≤ ingredient의 길이 ≤ 1,000,000
 * ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
 * 입출력 예
 * ingredient	result
 * [2, 1, 1, 2, 3, 1, 2, 3, 1]	2
 * [1, 3, 2, 1, 2, 1, 3, 1, 2]	0
 * 입출력 예 설명
 * 입출력 예 #1
 * <p>
 * 문제 예시와 같습니다.
 * 입출력 예 #2
 * <p>
 * 상수가 포장할 수 있는 햄버거가 없습니다.
 */
public class MakingHamburger {
    public int makingHamburger(int[] ingredient) {
        int hamburgerCnt = 0;
        List<Integer> ingredientList = new ArrayList<>();
        for (int j : ingredient) {
            ingredientList.add(j);
        }


        int[] recipe = {1, 2, 3, 1};
        int recipeIndex = 0;
        int index = 0;
        int hamburgerStartIdx = -1;
        while (index != ingredientList.size()) {
            Integer get = ingredientList.get(index);
            if (recipeIndex == 0) {
                hamburgerStartIdx = index;
            }

            if (get == recipe[recipeIndex]) {
                recipeIndex++;
            } else if (get == recipe[0]) {
                hamburgerStartIdx = index;
                recipeIndex = 1;
            } else {
                recipeIndex = 0;
                hamburgerStartIdx = -1;
            }

            index++;
            if (recipeIndex == recipe.length) {
                for (int i = 0; i < recipe.length; i++) {
                    ingredientList.remove(hamburgerStartIdx);
                }
                hamburgerCnt++;
                recipeIndex = 0;
                if (hamburgerStartIdx - recipe.length - 1 >= 0) {
                    index = hamburgerStartIdx - recipe.length - 1;
                } else {
                    index = 0;
                }
            }
        }

        return hamburgerCnt;
    }

    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}
