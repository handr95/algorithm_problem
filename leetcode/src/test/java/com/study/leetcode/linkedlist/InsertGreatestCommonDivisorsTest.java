package com.study.leetcode.linkedlist;

import com.study.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static com.study.leetcode.common.ListNode.createLinkedList;
import static org.assertj.core.api.Assertions.assertThat;

public class InsertGreatestCommonDivisorsTest {
    InsertGreatestCommonDivisors insertGreatestCommonDivisors = new InsertGreatestCommonDivisors();
    @Test
    void test1() {
        ListNode node = createLinkedList(new int[]{18,6,10,3});
        ListNode expect = createLinkedList(new int[]{18,6,6,2,10,1,3});

        assertThat(insertGreatestCommonDivisors.insertGreatestCommonDivisors(node)).isEqualTo(expect);
    }

    @Test
    void test2() {
        ListNode node = createLinkedList(new int[]{7});
        ListNode expect = createLinkedList(new int[]{7});

        assertThat(insertGreatestCommonDivisors.insertGreatestCommonDivisors(node)).isEqualTo(expect);
    }
}
