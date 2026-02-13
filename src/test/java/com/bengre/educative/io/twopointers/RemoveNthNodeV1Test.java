package com.bengre.educative.io.twopointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveNthNodeV1Test {

    private final RemoveNthNodeV1 solver = new RemoveNthNodeV1();

    // --- Helper Methods ---

    private ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    private int[] listToArray(ListNode head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    // --- Tests ---

    @Test
    @DisplayName("Should remove middle node (Standard Case)")
    void testRemoveMiddle() {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result = solver.removeNthLastNode(head, 2);
        assertArrayEquals(new int[]{1, 2, 3, 5}, listToArray(result));
    }

    @Test
    @DisplayName("Should remove the head node")
    void testRemoveHead() {
        ListNode head = createList(new int[]{1, 2});
        ListNode result = solver.removeNthLastNode(head, 2);
        assertArrayEquals(new int[]{2}, listToArray(result));
    }

    @Test
    @DisplayName("Should return null when removing the only node")
    void testRemoveOnlyNode() {
        ListNode head = createList(new int[]{1});
        ListNode result = solver.removeNthLastNode(head, 1);
        assertNull(result);
    }

    @Test
    @DisplayName("Should remove the last node")
    void testRemoveLast() {
        ListNode head = createList(new int[]{1, 2, 3});
        ListNode result = solver.removeNthLastNode(head, 1);
        assertArrayEquals(new int[]{1, 2}, listToArray(result));
    }
}
