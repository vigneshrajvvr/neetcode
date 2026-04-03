/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        Node traversalNode = head;
        Node copiedRandomListHead = null;

        // Create a deep copy of the nodes in the exisiting list
        while(traversalNode != null) {
            Node copiedNode = new Node(traversalNode.val);
            copiedNode.next = traversalNode.next;
            traversalNode.next = copiedNode;
            traversalNode = traversalNode.next.next;
        }

        // Map the random pointers for the deep copied nodes
        traversalNode = head;
        while(traversalNode != null) {
            if(traversalNode.random != null) {
                traversalNode.next.random = traversalNode.random.next;
            }
            traversalNode = traversalNode.next.next;
        }

        // Separate the list of copied nodes
        traversalNode = head;
        Node deepCopiedTraversalNode = null;
        copiedRandomListHead = traversalNode.next;
        Node deepCopiedPrev = null;
        while(traversalNode != null) {
            deepCopiedTraversalNode = traversalNode.next;
            traversalNode.next = traversalNode.next.next;
            traversalNode = traversalNode.next;
            if(deepCopiedPrev != null) {
                deepCopiedPrev.next = deepCopiedTraversalNode;
            }
            deepCopiedPrev = deepCopiedTraversalNode;
        }

        return copiedRandomListHead;
    }
}