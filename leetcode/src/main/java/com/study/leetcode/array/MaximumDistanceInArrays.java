package com.study.leetcode.array;

import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 * https://leetcode.com/problems/maximum-distance-in-arrays/description/?envType=study-plan-v2&envId=premium-algo-100
 * Medium
 * 
 * 각 배열이 오름차순으로 정렬된 m개의 배열이 주어집니다.
 * 두 개의 서로 다른 배열에서 두 개의 정수를 선택하고(각 배열은 하나를 선택) 거리를 계산할 수 있습니다. 
 * 두 정수 a와 b 사이의 거리를 두 정수의 절대 차이인 |a - b|로 정의합니다.
 * 
 * 최대 거리를 반환합니다.
 * 
 * Example 1:
 * Input: arrays = [[1,2,3],[4,5],[1,2,3]]
 * Output: 4
 * Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *
 * Example 2:
 * Input: arrays = [[1],[1]]
 * Output: 0
 *
 * Constraints:
 *  m == arrays.length
 *  2 <= m <= 105
 *  1 <= arrays[i].length <= 500
 *  -104 <= arrays[i][j] <= 104
 *  arrays[i] is sorted in ascending order.
 *  There will be at most 105 integers in all the arrays.
 */
public class MaximumDistanceInArrays {
    
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int path = 0;

        for (int i = 1; i < arrays.size(); i ++) {
            int lastIndex = arrays.get(i).size() - 1;
            int minArr = arrays.get(i).get(0);
            int maxArr = arrays.get(i).get(lastIndex);
            if (maxArr - min > path) {
                path = maxArr - min;
            }
            if (max - minArr > path) {
                path = max - minArr;
            }

            min = Math.min(min, minArr);
            max = Math.min(max, maxArr);
        }

        return path;
    }
}
