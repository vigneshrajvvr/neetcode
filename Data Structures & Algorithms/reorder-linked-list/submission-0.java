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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        // Find half point of the linked list
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Reverse the pointer for the remaining half nodes
        ListNode midNode = slowPointer;
        ListNode reversedNode = slowPointer.next;
        ListNode next = null;
        ListNode prev = slowPointer;
        midNode.next = null;
        while(reversedNode != null) {
            next = reversedNode.next;
            reversedNode.next = prev;
            prev = reversedNode;
            reversedNode = next;
        }

        // Reorder the nodes
        ListNode traversalNode = head;
        reversedNode = prev;
        while(traversalNode != null && reversedNode != null && traversalNode != reversedNode) {
            prev = reversedNode.next;
            reversedNode.next = traversalNode.next;
            traversalNode.next = reversedNode;
            traversalNode = traversalNode.next.next;
            reversedNode = prev;
        }

        return;        
    }
}

// 1 -> 2 -> 3 <- 4
// 1 -> 4 -> 2 -> 3

// 1 -> 2 -> 3 <- 4 <- 5
// 1 -> 5 -> 2 -> 3 <- 4
// 1 -> 5 -> 2 -> 4 -> 3