package com.study.leetcode.array;

/**
 88. 정렬된 배열 병합
 쉬운
 https://leetcode.com/problems/merge-sorted-array/submissions/1197477725/?envType=study-plan-v2&envId=top-interview-150


 감소하지 않는 순서로 정렬된 두 개의 정수 배열 nums1과 nums2가 주어지고, nums1과 nums2의 요소 수를 각각 나타내는 두 개의 정수 m과 n이 주어집니다.

 nums1과 nums2를 감소하지 않는 순서로 정렬된 단일 배열로 병합합니다.

 최종 정렬된 배열은 함수에 의해 반환되지 않고 nums1 배열 안에 저장되어야 합니다. 이를 위해 nums1의 길이는 m + n이며,
 여기서 첫 번째 m 요소는 병합해야 하는 요소를 나타내고 마지막 n 요소는 0으로 설정되어 무시해야 합니다. nums2의 길이는 n입니다.



 예제 1:

 입력: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 출력 [1,2,2,3,5,6]
 설명: 병합하는 배열은 [1,2,3]과 [2,5,6]입니다.
 병합 결과는 [1,2,2,3,5,6]이며 밑줄이 그어진 요소는 nums1에서 가져온 것입니다.
 예제 2:

 입력: nums1 = [1], m = 1, nums2 = [], n = 0
 출력 [1]
 설명: 병합하는 배열은 [1]과 []입니다.
 병합 결과는 [1]입니다.
 예제 3:

 입력: nums1 = [0], m = 0, nums2 = [1], n = 1
 출력 [1]
 설명: 병합하는 배열은 []와 [1]입니다.
 병합의 결과는 [1]입니다.
 m = 0이므로 nums1에는 요소가 없습니다. 0은 병합 결과가 nums1에 맞을 수 있도록 하기 위해서만 존재합니다.


 제약 조건:

 nums1.length == m + n
 nums2.length == n
 0 <= m, n <= 200
 1 <= m + n <= 200
 -109 <= nums1[i], nums2[j] <= 109



 따라해 봅시다: O(m + n) 시간 안에 실행되는 알고리즘을 생각해낼 수 있나요?
 */
public class MergeSortedArray {

    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0) {
            return;
        }

        int startIdx1 = 0;
        int startIdx2 = 0;
        int[] result = new int[m + n];
        for (int i = 0; i < result.length; i++) {
            if (startIdx1 == m) {
                result[i] = nums2[startIdx2];
                startIdx2++;
                continue;
            }

            if (startIdx2 == n) {
                result[i] = nums1[startIdx1];
                startIdx1++;
                continue;
            }
            if (nums1[startIdx1] > nums2[startIdx2]) {
                result[i] = nums2[startIdx2];
                startIdx2++;
            } else {
                result[i] = nums1[startIdx1];
                startIdx1++;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result[i];
        }
    }

    public void solution(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}