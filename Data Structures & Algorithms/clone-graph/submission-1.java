/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }

        Map<Node, Node> nodesMapping = new HashMap<>();

        Node copiedGraph = dfs(node, nodesMapping);

        return copiedGraph;
    }

    private Node dfs(Node node, Map<Node, Node> nodesMapping) {
        if(nodesMapping.containsKey(node)) {
            return nodesMapping.get(node);
        }

        Node copiedNode = new Node(node.val);
        copiedNode.neighbors = new ArrayList<>();
        nodesMapping.put(node, copiedNode);

        for(Node originalNeighbor : node.neighbors) {
            copiedNode.neighbors.add(dfs(originalNeighbor, nodesMapping));
        }

        return copiedNode;
    }
}