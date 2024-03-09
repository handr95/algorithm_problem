package com.study.leetcode.linkedlist;

import com.study.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static com.study.leetcode.common.ListNode.createLinkedList;
import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    void test1() {
        ListNode node1 = createLinkedList(new int[]{2, 4, 3});
        ListNode node2 = createLinkedList(new int[]{6, 6, 4});
        ListNode expect = createLinkedList(new int[]{8, 0, 7});

        assertThat(addTwoNumbers.addTwoNumbers(node1, node2)).isEqualTo(expect);
    }

    @Test
    void test2() {
        ListNode node1 = createLinkedList(new int[]{0});
        ListNode node2 = createLinkedList(new int[]{0});
        ListNode expect = createLinkedList(new int[]{0});
        assertThat(addTwoNumbers.addTwoNumbers(node1, node2)).isEqualTo(expect);
    }

    @Test
    void test3() {
        ListNode node1 = createLinkedList(new int[]{9,9,9,9,9,9,9});
        ListNode node2 = createLinkedList(new int[]{9,9,9,9});
        ListNode expect = createLinkedList(new int[]{8,9,9,9,0,0,0,1});
        assertThat(addTwoNumbers.addTwoNumbers(node1, node2)).isEqualTo(expect);
    }
}
