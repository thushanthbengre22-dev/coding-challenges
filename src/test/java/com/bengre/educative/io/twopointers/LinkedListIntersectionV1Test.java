package com.bengre.educative.io.twopointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListIntersectionV1Test {

    private final LinkedListIntersectionV1 solver = new LinkedListIntersectionV1();

    @Test
    @DisplayName("Should return the intersection node when lists merge")
    void testIntersectionExists() {
        // Create the common part: 8 -> 10
        ListNode common = new ListNode(8);

        common.next = new ListNode(10);

        // List A: 4 -> 1 -> (common)
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B: 5 -> 6 -> 1 -> (common)
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        // The intersection is the object reference of 'common'
        assertEquals(common, solver.getIntersectionNode(headA, headB));
    }

    @Test
    @DisplayName("Should return null when no intersection exists")
    void testNoIntersection() {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);

        ListNode headB = new ListNode(3);
        headB.next = new ListNode(4);

        assertNull(solver.getIntersectionNode(headA, headB));
    }

    @Test
    @DisplayName("Should handle cases where one list is a suffix of the other")
    void testFullSuffixIntersection() {
        ListNode common = new ListNode(1);
        ListNode headA = common;

        ListNode headB = new ListNode(2);
        headB.next = common;

        assertEquals(common, solver.getIntersectionNode(headA, headB));
    }
}
