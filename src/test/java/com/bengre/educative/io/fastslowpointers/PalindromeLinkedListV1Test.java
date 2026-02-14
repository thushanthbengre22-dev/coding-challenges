package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeLinkedListV1Test {
    private PalindromeLinkedListV1 detector;

    @BeforeEach
    void setUp() {
        detector = new PalindromeLinkedListV1();
    }

    /**
     * Helper method to verify the list hasn't been modified.
     */
    private void assertListUnchanged(ListNode head, int[] originalValues) {
        ListNode current = head;
        for (int val : originalValues) {
            assertNotNull(current, "List is shorter than expected");
            assertEquals(val, current.val, "List structure/value was modified");
            current = current.next;
        }
        assertNull(current, "List is longer than expected");
    }

    @Test
    @DisplayName("Should return true for an even-length palindrome")
    void testEvenPalindrome() {
        int[] values = {1, 2, 2, 1};
        ListNode head = createLinkedList(values);

        assertTrue(detector.palindrome(head));
        assertListUnchanged(head, values);
    }

    @Test
    @DisplayName("Should return true for an odd-length palindrome")
    void testOddPalindrome() {
        int[] values = {1, 2, 3, 2, 1};
        ListNode head = createLinkedList(values);

        assertTrue(detector.palindrome(head));
        assertListUnchanged(head, values);
    }

    @Test
    @DisplayName("Should return false for a non-palindrome")
    void testNotPalindrome() {
        int[] values = {1, 2, 3};
        ListNode head = createLinkedList(values);

        assertFalse(detector.palindrome(head));
        assertListUnchanged(head, values);
    }

    @Test
    @DisplayName("Should return true for a single node (n=1)")
    void testSingleNode() {
        int[] values = {5};
        ListNode head = createLinkedList(values);

        assertTrue(detector.palindrome(head));
        assertListUnchanged(head, values);
    }

    @Test
    @DisplayName("Should return true for two identical nodes")
    void testTwoIdenticalNodes() {
        int[] values = {1, 1};
        ListNode head = createLinkedList(values);

        assertTrue(detector.palindrome(head));
        assertListUnchanged(head, values);
    }

    // Helper to build list from array
    private ListNode createLinkedList(int[] arr) {
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
