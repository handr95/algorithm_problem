package com.study.leetcode.array;

/**
 * 238. Product of Array Except Self
 * Medium
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 정수 배열 nums가 주어졌을 때, answer[i]가 nums[i]를 제외한 nums의 모든 요소의 곱과 같도록 배열 답을 반환합니다.
 *
 * nums의 접두사 또는 접미사의 곱은 32비트 정수에 맞도록 보장됩니다.
 *
 * 나누기 연산을 사용하지 않고 O(n) 시간 내에 실행되는 알고리즘을 작성해야 합니다.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *  2 <= nums.length <= 10^5
 *  -30 <= nums[i] <= 30
 *  The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1 ; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }


        int[] right = new int[nums.length];
        right[left.length - 1] = 1;
        for(int i = left.length - 2 ; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            result[i] = right[i] * left[i];
        }

        return result;
    }

    public int[] solution1(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];
        result[0] = 1;

        // 왼쪽 부분 배열의 곱을 계산하여 결과에 저장
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 오른쪽 부분 배열의 곱과 결과를 계산하면서 업데이트
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    public int[] solution2(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        // 왼쪽 부분 배열의 곱과 오른쪽 부분 배열의 곱을 동시에 계산하여 결과에 저장
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
