class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) {
            return false;
        }

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] currentEdge : edges) {
            if(!unionFind(currentEdge[0], currentEdge[1], parent)) {
                return false;
            }
        }

        return true;
    }

    private boolean unionFind(int source, int destination, int[] parent) {
        int root1 = findRoot(source, parent);
        int root2 = findRoot(destination, parent);

        if(root1 == root2) {
            return false;
        }

        if(source <= destination) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }

        return true;
    }

    private int findRoot(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }

        parent[node] = findRoot(parent[node], parent);

        return parent[node];
    }
}

// 0 to n - 1 nodes
// edges[i] - undirected edges