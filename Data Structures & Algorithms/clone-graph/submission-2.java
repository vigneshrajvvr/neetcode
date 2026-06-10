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
            return null;
        }

        HashMap<Node, Node> nodeMapper = new HashMap<>();
        return cloneGraphHelper(node, nodeMapper);
    }

    private Node cloneGraphHelper(Node node, HashMap<Node, Node> nodeMapper) {
        if(nodeMapper.containsKey(node)) {
            return nodeMapper.get(node);
        }

        Node mappedNode = new Node(node.val);
        nodeMapper.put(node, mappedNode);

        for(Node neighbor : node.neighbors) {
            mappedNode.neighbors.add(cloneGraphHelper(neighbor, nodeMapper));
        }

        return mappedNode;
    }
}