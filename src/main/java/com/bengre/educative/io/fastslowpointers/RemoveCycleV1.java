package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;

public class RemoveCycleV1 {

    public static ListNode removeCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        // if there is no loop
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    prev = slow;
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                prev.next = null;
                return head;
            }
        }

        return head;


    }
}
