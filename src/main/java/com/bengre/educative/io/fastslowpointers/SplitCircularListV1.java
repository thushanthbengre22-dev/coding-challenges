package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;

public class SplitCircularListV1 {

    public ListNode[] splitCircularLinkedList(ListNode head) {
        ListNode[] res = new ListNode[2];
        int count = 0;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            count ++;
        } while (slow != fast);
        slow = head;
        fast = head.next;
        ListNode head1 = head;
        int mid = 0;
        if (count % 2 == 0) {
            mid = count / 2;
        } else {
            mid = (count / 2) + 1;
        }
        for (int i = 1; i < mid; i++) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = head1;
        res[0] = head1;
        ListNode head2 = fast;
        for (int i = mid; i < count - 1; i++) {
            fast = fast.next;
        }
        fast.next = head2;
        res[1] = head2;

        return res;

    }
}
