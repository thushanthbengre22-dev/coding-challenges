package com.bengre.educative.io.twopointers;

import com.bengre.educative.io.common.ListNode;

public class RemoveNthNodeV1 {

    public ListNode removeNthLastNode(ListNode head, int n) {
        ListNode temp = head;
        int length = 1;
        while(temp.next != null) {
            length++;
            temp = temp.next;
        }

        int nodeToRemove = length - n + 1;

        if (nodeToRemove == 1) {
            return head.next;
        }
        ListNode curr = head;
        for (int i = 1; i <= nodeToRemove; i++) {
            if (i == nodeToRemove-1) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
