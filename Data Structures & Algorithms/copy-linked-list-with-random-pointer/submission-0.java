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
        Map<Node, Node> nodeMapper = new HashMap<>();
        Node traversalNode = head;
        Node copiedNodePrev = null;
        Node deepCopyHead = null;

        while(traversalNode != null) {
            Node copiedNode = new Node(traversalNode.val);
            nodeMapper.put(traversalNode, copiedNode);

            if(deepCopyHead == null) {
                deepCopyHead = copiedNode;
            }

            if(copiedNodePrev != null) {
                copiedNodePrev.next = copiedNode;
            } 
            copiedNodePrev = copiedNode;
            traversalNode = traversalNode.next;
        }

        traversalNode = head;
        Node deepCopyTraversalNode = deepCopyHead;
        printNode(deepCopyTraversalNode);
        while(traversalNode != null) {
            if(traversalNode.random != null) {
                deepCopyTraversalNode.random = nodeMapper.get(traversalNode.random);
            }

            traversalNode = traversalNode.next;
            deepCopyTraversalNode = deepCopyTraversalNode.next;
        }

        return deepCopyHead;
    }

    public void printNode(Node traversalNode) {
        while(traversalNode != null) {
            traversalNode = traversalNode.next;
        }
    }
}