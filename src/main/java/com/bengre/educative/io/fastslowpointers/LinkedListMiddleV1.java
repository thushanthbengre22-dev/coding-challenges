package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;

public class LinkedListMiddleV1 {

    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
