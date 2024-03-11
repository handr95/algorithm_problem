package com.study.leetcode.array;

/**
 * 27. Remove Element
 * Easy
 * https://leetcode.com/problems/remove-element/description
 *
 * 정수 배열 nums와 정수 val이 주어졌을 때, nums에서 val이 포함된 모든 요소를 제자리에서 제거합니다. 요소의 순서는 변경될 수 있습니다. 그런 다음 nums에서 val과 같지 않은 요소의 수를 반환합니다.
 *
 * nums에서 val과 같지 않은 요소의 개수가 k라고 가정하면 다음과 같은 작업을 수행해야 허용됩니다:
 *
 * nums의 첫 번째 k 요소에 val과 같지 않은 요소가 포함되도록 배열 nums를 변경합니다. nums의 나머지 요소는 nums의 크기만큼 중요하지 않습니다.
 * k를 반환합니다.
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int tempIdx = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[tempIdx] = nums[i];
                tempIdx ++;
            }
        }
        return tempIdx;
    }
}
