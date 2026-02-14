package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;

public class CycleLengthV1 {

    public int countCycleLength(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if ((fast == null) || (fast.next == null)) {
            return 0;
        }
        fast = slow;
        int count = 0;
        do {
            fast = fast.next;
            count ++;
        } while(fast != slow);

        return count;

    }


}
