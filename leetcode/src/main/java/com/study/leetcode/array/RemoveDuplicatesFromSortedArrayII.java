package com.study.leetcode.array;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Medium
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description
 *
 * 정수 배열의 숫자가 감소하지 않는 순서로 정렬되어 있을 때, 각 고유 요소가 최대 두 번만 나타나도록 중복된 부분을 제자리에서 제거합니다. 
 * 요소의 상대적 순서는 동일하게 유지해야 합니다.
 *
 * 일부 언어에서는 배열의 길이를 변경할 수 없으므로 대신 배열의 첫 번째 부분에 결과를 배치해야 합니다. 좀 더 공식적으로 말하자면,
 * 중복을 제거한 후 요소가 k 개 있는 경우 nums의 처음 k 개 요소가 최종 결과를 보유해야 합니다. 
 * 첫 번째 k 요소 너머에 무엇이 남는지는 중요하지 않습니다.
 *
 * nums의 처음 k 슬롯에 최종 결과를 배치한 후 k를 반환합니다.
 *
 * 다른 배열을 위한 추가 공간을 할당하지 마세요. 입력 배열을 제자리에서 수정하여 O(1)의 추가 메모리를 확보해야 합니다.
 *
 * Custom Judge:
 *  The judge will test your solution with the following code:
 *
 *  int[] nums = [...]; // Input array
 *  int[] expectedNums = [...]; // The expected answer with correct length
 *
 *  int k = removeDuplicates(nums); // Calls your implementation
 *
 *  assert k == expectedNums.length;
 *  for (int i = 0; i < k; i++) {
 *      assert nums[i] == expectedNums[i];
 *  }
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 *   1 <= nums.length <= 3 * 104
 *  -10^4 <= nums[i] <= 10^4
 *   nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int prev = nums[0];
        int index = 1;
        for (int i  = 1;  i < nums.length; i ++) {
            if (prev == nums[i] && cnt >= 2) {
                cnt ++;
            } else if(prev == nums[i] && cnt == 1) {
                nums[index] = nums[i];
                index ++;
                cnt ++;
            } else {
                nums[index] = nums[i];
                index ++;
                cnt = 1;
            }
            prev = nums[i];
        }
        return index;
    }

    public int solution(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
