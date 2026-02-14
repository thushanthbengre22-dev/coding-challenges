package com.bengre.educative.io.fastslowpointers;

import com.bengre.educative.io.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class TwinSumV1 {

    public int twinSum(ListNode head) {
        if (head.next.next == null ){
            return head.val + head.next.val;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        while (fast != null) {
            res.add(stack.pop() + fast.val);
            fast = fast.next;
        }

        Collections.sort(res);
        return res.get(res.size() -1);


    }


}
