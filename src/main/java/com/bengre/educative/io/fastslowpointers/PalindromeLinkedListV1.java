package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;

import java.util.Stack;

public class PalindromeLinkedListV1 {

    public boolean palindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        if (head.next == null) {
            return true;
        }
        ListNode slow = head;
        stack.push(slow);
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            stack.push(slow);
            fast = fast.next.next;
        }
        if (fast != null && fast.next == null) {
            stack.pop();
        }
        if (fast == null) {
            stack.pop();
            fast = slow;
        } else {
            fast = slow.next;
        }
        while (fast != null) {
            int num = stack.pop().val;
            if (num != fast.val) {
                return false;
            }
            fast = fast.next;
        }
        return true;
    }
}
