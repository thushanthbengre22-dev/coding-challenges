package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListCycleV1Test {

    private LinkedListCycleV1 detector;

    @BeforeEach
    void setUp() {
        detector = new LinkedListCycleV1();
    }

    @Test
    @DisplayName("Should return true when a cycle exists")
    void testCycleExists() {
        // Create nodes: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create cycle: -4 points back to 2
        node4.next = node2;

        assertTrue(detector.detectCycle(head), "Expected true for a list with a cycle");
    }

    @Test
    @DisplayName("Should return false when no cycle exists")
    void testNoCycle() {
        // Create nodes: 1 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        assertFalse(detector.detectCycle(head), "Expected false for a linear list");
    }

    @Test
    @DisplayName("Should return false for an empty list (n=0)")
    void testEmptyList() {
        assertFalse(detector.detectCycle(null), "Expected false for null input");
    }

    @Test
    @DisplayName("Should return false for a single node with no cycle")
    void testSingleNode() {
        ListNode head = new ListNode(10);
        assertFalse(detector.detectCycle(head), "Expected false for a single node with no self-loop");
    }

    @Test
    @DisplayName("Should return true for a single node pointing to itself")
    void testSingleNodeSelfCycle() {
        ListNode head = new ListNode(1);
        head.next = head;
        assertTrue(detector.detectCycle(head), "Expected true for a self-looping node");
    }
}
