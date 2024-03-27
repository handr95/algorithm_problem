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

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int index = 1;
        for (int i = citations.length - 1; i >= 0; i --){
            if (index > citations[i]) {
                return index - 1;
            }
            index ++;
        }
        return citations[0] > index - 1 ? index - 1 :  citations[0];
    }
}
