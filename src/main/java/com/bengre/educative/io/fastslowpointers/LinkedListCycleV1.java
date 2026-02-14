package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;

public class LinkedListCycleV1 {

    public boolean detectCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }
}
