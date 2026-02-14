package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListMiddleV1Test {

    private LinkedListMiddleV1 finder;

    @BeforeEach
    void setUp() {
        finder = new LinkedListMiddleV1();
    }

    @Test
    @DisplayName("Should return the exact middle for an odd-length list")
    void testOddLengthList() {
        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result = finder.middleNode(head);

        // Middle should be 3
        assertNotNull(result);
        assertEquals(3, result.val);
    }

    @Test
    @DisplayName("Should return the second middle for an even-length list")
    void testEvenLengthList() {
        // List: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = createList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode result = finder.middleNode(head);

        // Middle nodes are 3 and 4; should return 4
        assertNotNull(result);
        assertEquals(4, result.val);
    }

    @Test
    @DisplayName("Should return the same node for a single-node list")
    void testSingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = finder.middleNode(head);

        assertEquals(1, result.val);
    }

    @Test
    @DisplayName("Should return the second node for a two-node list")
    void testTwoNodes() {
        // List: 1 -> 2
        ListNode head = createList(new int[]{1, 2});
        ListNode result = finder.middleNode(head);

        // Second middle is 2
        assertEquals(2, result.val);
    }

    // Helper method to build the list
    private ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
