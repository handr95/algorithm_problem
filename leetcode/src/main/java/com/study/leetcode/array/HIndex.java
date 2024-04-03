package com.study.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 274. H-Index
 * https://leetcode.com/problems/h-index/description/
 * Medium
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Integer[] sortedInteger = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        for (int i = 0; i < sortedInteger.length; i ++){
            if (i + 1 > sortedInteger[i]) {
                return i;
            }
        }
        return sortedInteger.length;
    }

    // 인용횟수가 h번 이상인 논문이 적어도 h편이 되는 h의 최대값
    public int hIndex2(int[] citations) {
        // 오름차순 정렬
        Arrays.sort(citations);
        int index = 1;
        // 마지막 인덱스부터 for 문 시작
        for (int i = citations.length - 1; i >= 0; i --){
            // 피인용수가 논문수보다 작아지기 직전의 숫자 검색
            if (index > citations[i]) {
                return index - 1;
            }
            index ++;
        }
        return Math.min(citations[0], index - 1);
    }
}
