package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CycleLengthV1Test {

    private CycleLengthV1 calculator;

    @BeforeEach
    void setUp() {
        calculator = new CycleLengthV1();
    }

    @Test
    @DisplayName("Should return correct length for a cycle in the middle")
    void testCycleInMiddle() {
        // 1 -> 2 -> 3 -> 4 -> 5 -> (back to 2)
        // Cycle nodes: 2, 3, 4, 5 (Length = 4)
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2; // Cycle back to 2

        assertEquals(4, calculator.countCycleLength(head));
    }

    @Test
    @DisplayName("Should return 1 for a self-loop")
    void testSelfLoop() {
        // 1 -> 2 -> (back to 2)
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        node2.next = node2;

        assertEquals(1, calculator.countCycleLength(head));
    }

    @Test
    @DisplayName("Should return 0 when no cycle exists")
    void testNoCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        assertEquals(0, calculator.countCycleLength(head));
    }

    @Test
    @DisplayName("Should return 0 for an empty list")
    void testEmptyList() {
        assertEquals(0, calculator.countCycleLength(null));
    }

    @Test
    @DisplayName("Should return length for a cycle involving the whole list")
    void testFullListCycle() {
        // 1 -> 2 -> 3 -> (back to 1)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;

        assertEquals(3, calculator.countCycleLength(head));
    }
}
