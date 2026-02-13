package com.bengre.educative.io.twopointers;

import com.bengre.educative.io.common.ListNode;

public class LinkedListIntersectionV1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        ListNode temp = headB;

        while(headA != null) {
            while(headB != null) {
                if (headA == headB) {
                    return headB;
                } else {
                    headB = headB.next;
                }
            }
            headA = headA.next;
            headB = temp;
        }
        return null;
    }
}
