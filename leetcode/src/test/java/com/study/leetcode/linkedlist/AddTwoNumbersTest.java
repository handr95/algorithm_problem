package com.study.leetcode.linkedlist;

import com.study.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    void test1() {
        ListNode l1n1 = new ListNode(3);
        ListNode l1n2 = new ListNode(4, l1n1);
        ListNode l1n3 = new ListNode(2, l1n2);

        ListNode l2n1 = new ListNode(4);
        ListNode l2n2 = new ListNode(6, l2n1);
        ListNode l2n3 = new ListNode(5, l2n2);

        ListNode output = addTwoNumbers.addTwoNumbers(l1n3, l2n3);
        int[] expect = {7, 0, 8};
        for (int expectVal : expect) {
            assertThat(output).isNotNull();
            assertThat(output.val).isEqualTo(expectVal);
            output = output.next;
        }
    }

    @Test
    void test2() {
        ListNode l1n1 = new ListNode(0);
        ListNode l2n1 = new ListNode(0);

        ListNode output = addTwoNumbers.addTwoNumbers(l1n1, l2n1);
        int[] expect = {0};
        for (int expectVal : expect) {
            assertThat(output).isNotNull();
            assertThat(output.val).isEqualTo(expectVal);
            output = output.next;
        }
    }

    @Test
    void test3() {
        ListNode l1n1 = new ListNode(9);
        ListNode l1n2 = new ListNode(9, l1n1);
        ListNode l1n3 = new ListNode(9, l1n2);
        ListNode l1n4 = new ListNode(9, l1n3);
        ListNode l1n5 = new ListNode(9, l1n4);
        ListNode l1n6 = new ListNode(9, l1n5);
        ListNode l1n7 = new ListNode(9, l1n6);

        ListNode l2n1 = new ListNode(9);
        ListNode l2n2 = new ListNode(9, l2n1);
        ListNode l2n3 = new ListNode(9, l2n2);
        ListNode l2n4 = new ListNode(9, l2n3);

        ListNode output = addTwoNumbers.addTwoNumbers(l1n7, l2n4);
        int[] expect = {8,9,9,9,0,0,0,1};
        for (int expectVal : expect) {
            assertThat(output).isNotNull();
            assertThat(output.val).isEqualTo(expectVal);
            output = output.next;
        }
    }
}
