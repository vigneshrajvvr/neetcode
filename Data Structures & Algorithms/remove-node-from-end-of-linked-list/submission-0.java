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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while(n > 0) {
            fastPointer = fastPointer.next;
            n--;
        }

        while(fastPointer != null) {
            fastPointer = fastPointer.next;
            prev = slowPointer;
            slowPointer = slowPointer.next;
        }

        if(prev == null) {
            head = head.next;
        } else {
            if(prev.next != null) {
                prev.next = prev.next.next;
            }
        }

        return head;        
    }
}