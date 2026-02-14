package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveCycleV1Test {

    private RemoveCycleV1 solver;

    @BeforeEach
    void setUp() {
        solver = new RemoveCycleV1();
    }

    @Test
    @DisplayName("Should remove a cycle in the middle of the list")
    void testRemoveMiddleCycle() {
        // 1 -> 2 -> 3 -> 4 -> 5 -> (back to 3)
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        n5.next = n3; // Cycle starts at 3

        solver.removeCycle(head);

        // Verify cycle is gone
        assertNoCycle(head);
        // Verify path is preserved: 1-2-3-4-5-null
        assertPath(head, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    @DisplayName("Should remove a cycle that loops back to the head")
    void testRemoveHeadCycle() {
        // 1 -> 2 -> 3 -> (back to 1)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;

        solver.removeCycle(head);

        assertNoCycle(head);
        assertPath(head, new int[]{1, 2, 3});
    }

    @Test
    @DisplayName("Should remove a self-loop")
    void testRemoveSelfLoop() {
        // 1 -> 2 -> (back to 2)
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n2;
        n2.next = n2;

        solver.removeCycle(head);

        assertNoCycle(head);
        assertPath(head, new int[]{1, 2});
    }

    @Test
    @DisplayName("Should not modify an acyclic list")
    void testAcyclicList() {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);

        solver.removeCycle(head);

        assertNoCycle(head);
        assertPath(head, new int[]{10, 20});
    }

    // Helper: Verify no cycle exists using two pointers
    private void assertNoCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) fail("Cycle still exists in the list!");
        }
    }

    // Helper: Verify values and order
    private void assertPath(ListNode head, int[] expected) {
        ListNode curr = head;
        for (int val : expected) {
            assertNotNull(curr);
            assertEquals(val, curr.val);
            curr = curr.next;
        }
        assertNull(curr, "List did not end where expected");
    }
}
