package com.study.leetcode.linkedlist;

import com.study.leetcode.common.ListNode;

/**
 * 2. Add Two Numbers
 * Medium
 * https://leetcode.com/problems/add-two-numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tmp = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;

            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (result == null ) {
                result = new ListNode(sum);
                tmp = result;
            } else {
                tmp.next = new ListNode(sum);
                tmp = tmp.next;
            }
        }
        if (carry != 0) {
            tmp.next =  new ListNode(carry);
        }

        return result;
    }

    /**
     * 1. 값이 0인 dummyHead라는 자리 표시자 노드를 만듭니다. 이 노드에 결과 링크된 목록이 저장됩니다.
     * 2. tail이라는 포인터를 초기화하고 이를 dummyHead로 설정합니다. 이 포인터는 결과 목록의 마지막 노드를 추적합니다.
     * 3. carry라는 변수를 0으로 초기화합니다. 이 변수는 더하는 동안 캐리 값을 저장합니다.
     * 4. 두 입력 목록(l1 및 l2)에 더 이상 자릿수가 없고 남은 캐리 값이 없을 때까지 계속되는 루프를 시작합니다.
     * 5. 루프 내부를 살펴봅니다:
     *  - l1의 현재 노드에 자릿수가 있는지 확인합니다. 숫자가 있으면 그 값을 digit1이라는 변수에 할당합니다. 그렇지 않으면 digit1을 0으로 설정합니다.
     *  - l2의 현재 노드에 숫자가 있는지 확인합니다. 숫자가 있으면 digit2라는 변수에 그 값을 할당합니다. 그렇지 않으면 digit2를 0으로 설정합니다.
     *  - 이전 반복의 캐리 값과 함께 l1과 l2의 현재 자릿수를 더하고 그 합을 sum이라는 변수에 저장합니다.
     *  - 합의 모듈러스(%)를 10으로 하여 합의 단위 자릿수를 계산합니다. 이 숫자는 결과에 대한 새 노드에 배치됩니다.
     *  - sum을 10으로 나누고 정수 나누기(/) 부분을 취하여 캐리 변수를 업데이트합니다. 이렇게 하면 다음 반복에 대한 캐리 값을 얻을 수 있습니다.
     *  - 계산된 숫자를 값으로 사용하여 새 노드를 만듭니다.
     *  - 새 노드를 결과 목록의 꼬리 노드에 연결합니다.
     *  - 꼬리 포인터를 새로 추가된 노드로 이동합니다.
     *  - L1과 L2 모두에 다음 노드가 있는 경우 해당 노드로 이동합니다. 두 목록 중 하나가 모두 소진되면 해당 포인터를 nullptr로 설정합니다.
     * 6. 루프가 끝나면 dummyHead 노드를 건너뛰어 실제 결과 목록을 얻습니다.
     * 7. dummyHead 노드를 삭제합니다.
     * 8. 결과 리스트를 반환합니다.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}
