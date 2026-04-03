/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode added = null;
        ListNode total = null;
        ListNode prev = null;

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        while(l1 != null && l2 != null) {
            int rem = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            total = new ListNode(rem);
            if(added == null) {
                added = total;
            }
            if(prev == null) {
                prev = total;
            } else {
                prev.next = total;
                prev = prev.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int rem = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            total = new ListNode(rem);
            l1 = l1.next;
            prev.next = total;
            prev = prev.next;
        }

        while(l2 != null) {
            int rem = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            total = new ListNode(rem);
            l2 = l2.next;
            prev.next = total;
            prev = prev.next;
        }

        if(carry != 0) {
            prev.next = new ListNode(carry);
        }

        return added;
    }
}