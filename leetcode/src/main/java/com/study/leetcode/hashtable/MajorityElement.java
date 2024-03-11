package com.study.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * Easy
 * https://leetcode.com/problems/majority-element
 *
 * 크기가 n인 배열의 숫자가 주어지면 다수 요소를 반환합니다.
 *
 * 다수 요소는 ⌊n / 2⌋ 번 이상 나타나는 요소입니다. 다수 요소는 배열에 항상 존재한다고 가정할 수 있습니다.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 *  n == nums.length
 *  1 <= n <= 5 * 104
 *  -10^9 <= nums[i] <= 10^9
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int num : nums) {
            int cnt = elementMap.getOrDefault(num, 0);
            elementMap.put(num, ++cnt);
        }

        int majorElement = 0;
        int majorElementCnt = 0;
        for (Map.Entry<Integer, Integer> entry : elementMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (majorElementCnt < value) {
                majorElement = key;
                majorElementCnt = value;
            }
        }
        return majorElement;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int num : nums) {
            int cnt = elementMap.getOrDefault(num, 0);
            elementMap.put(num, ++cnt);
            if (cnt > nums.length / 2) {
                return num;
            }
        }
        return nums[0];
    }

    public int solution(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}
