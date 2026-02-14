package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SplitCircularListV1Test {

    private SplitCircularListV1 solver;

    @BeforeEach
    void setUp() {
        solver = new SplitCircularListV1();
    }

    @Test
    @DisplayName("Should split an even-length circular list equally")
    void testEvenSplit() {
        // 1 -> 2 -> 3 -> 4 -> (back to 1)
        ListNode head = createCircularList(new int[]{1, 2, 3, 4});

        ListNode[] result = solver.splitCircularLinkedList(head);

        // List 1: 1 -> 2 -> (back to 1)
        assertCircularPath(result[0], new int[]{1, 2});
        // List 2: 3 -> 4 -> (back to 3)
        assertCircularPath(result[1], new int[]{3, 4});
    }

    @Test
    @DisplayName("Should split an odd-length circular list (first half gets ceiling)")
    void testOddSplit() {
        // 1 -> 2 -> 3 -> 4 -> 5 -> (back to 1)
        // Ceiling(5/2) = 3 nodes in first list
        ListNode head = createCircularList(new int[]{1, 2, 3, 4, 5});

        ListNode[] result = solver.splitCircularLinkedList(head);

        // List 1: 1 -> 2 -> 3 -> (back to 1)
        assertCircularPath(result[0], new int[]{1, 2, 3});
        // List 2: 4 -> 5 -> (back to 4)
        assertCircularPath(result[1], new int[]{4, 5});
    }

    @Test
    @DisplayName("Should handle the minimum size (n=2)")
    void testMinimumSize() {
        // 1 -> 2 -> (back to 1)
        ListNode head = createCircularList(new int[]{1, 2});
        ListNode[] result = solver.splitCircularLinkedList(head);

        assertCircularPath(result[0], new int[]{1});
        assertCircularPath(result[1], new int[]{2});
    }

    // Helper: Build a circular linked list
    private ListNode createCircularList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        curr.next = head; // Make it circular
        return head;
    }

    // Helper: Verify the list is circular and contains expected values
    private void assertCircularPath(ListNode head, int[] expected) {
        assertNotNull(head);
        ListNode curr = head;
        for (int val : expected) {
            assertEquals(val, curr.val);
            curr = curr.next;
        }
        assertEquals(head, curr, "The last node does not point back to the head!");
    }
}
