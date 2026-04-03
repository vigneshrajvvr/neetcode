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
    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        ListNode prev = null;

        while(head != null) {
            current = head;
            head = head.next;
            current.next = prev;
            prev = current;
        }

        return prev;
    }
}
