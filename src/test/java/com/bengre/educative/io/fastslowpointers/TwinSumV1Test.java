package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwinSumV1Test {

    private TwinSumV1 calculator;

    @BeforeEach
    void setUp() {
        calculator = new TwinSumV1();
    }

    @Test
    @DisplayName("Should return the sum of the only two nodes")
    void testMinimumSize() {
        // n = 2. Index 0 pairs with 1.
        ListNode head = createList(new int[]{5, 4});
        assertEquals(9, calculator.twinSum(head));
    }

    @Test
    @DisplayName("Should find max sum when twins are at the edges")
    void testMaxSumAtEdges() {
        // Pairs: (10, 1) = 11, (2, 3) = 5. Max = 11.
        ListNode head = createList(new int[]{10, 2, 3, 1});
        assertEquals(11, calculator.twinSum(head));
    }

    @Test
    @DisplayName("Should find max sum when twins are in the middle")
    void testMaxSumInMiddle() {
        // Pairs: (1, 3) = 4, (1, 100) = 101, (2, 2) = 4. Max = 101.
        ListNode head = createList(new int[]{1, 1, 2, 2, 100, 3});
        assertEquals(101, calculator.twinSum(head));
    }

    @Test
    @DisplayName("Should handle identical values correctly")
    void testIdenticalValues() {
        ListNode head = createList(new int[]{4, 4, 4, 4});
        assertEquals(8, calculator.twinSum(head));
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
