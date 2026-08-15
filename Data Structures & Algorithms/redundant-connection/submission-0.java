class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] result = new int[] {-1, -1};
        int[] parent = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if(!dsu(u, v, parent)) {
                result = new int[]{u, v};
            }
        }

        return result;
    }

    private boolean dsu(int node1, int node2, int[] parent) {
        int root1 = findRoot(node1, parent);
        int root2 = findRoot(node2, parent);

        if(root1 == root2) {
            return false;
        }

        if(node1 <= node2) {
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