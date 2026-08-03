class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        HashSet<Integer> components = new HashSet<>();

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] currentEdge : edges) {
            dsu(currentEdge[0], currentEdge[1], parent);
        }

        for(int i = 0; i < n; i++) {
            System.out.print(parent[i] + " " );
            components.add(findRoot(i, parent));
        }

        return components.size();
    }

    private void dsu(int source, int target, int[] parent) {
        int root1 = findRoot(source, parent);
        int root2 = findRoot(target, parent);

        if(root1 == root2) {
            return;
        }

        if(source <= target) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }
    }

    private int findRoot(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }

        parent[node] = findRoot(parent[node], parent);

        return parent[node];
    }
}