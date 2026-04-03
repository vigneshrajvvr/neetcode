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
    public boolean hasCycle(ListNode head) {
       HashSet<ListNode> visited = new HashSet<>();
        ListNode traversalNode = head;

        while(traversalNode != null) {
            if(visited.contains(traversalNode)) {
                return true;
            }
            visited.add(traversalNode);
            traversalNode = traversalNode.next;
        }

        return false; 
    }
}
