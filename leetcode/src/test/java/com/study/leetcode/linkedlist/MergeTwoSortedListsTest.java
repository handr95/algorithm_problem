package com.study.leetcode.linkedlist;

import com.study.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static com.study.leetcode.common.ListNode.createLinkedList;
import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedListsTest {
    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    void test01() {
        ListNode node1 = createLinkedList(new int[]{1, 2, 4});
        ListNode node2 = createLinkedList(new int[]{1, 3, 4});
        ListNode expect = createLinkedList(new int[]{1, 1, 2, 3, 4, 4});
        assertThat(mergeTwoSortedLists.mergeTwoLists(node1, node2))
                .isEqualTo(expect);
    }

    @Test
    void test02() {
        ListNode node1 = createLinkedList(new int[]{-9, 3});
        ListNode node2 = createLinkedList(new int[]{5, 7});
        ListNode expect = createLinkedList(new int[]{-9, 3, 5, 7});
        assertThat(mergeTwoSortedLists.mergeTwoLists(node1, node2))
                .isEqualTo(expect);
    }
}
