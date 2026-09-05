class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;
        int maxDistance = -1;
        PriorityQueue<int[]> dijkstra = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        dijkstra.add(new int[] {k, 0});

        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] route : times) {
            adjList.get(route[0]).add(new int[]{route[1], route[2]});
        }

        while(!dijkstra.isEmpty()) {
            int[] path = dijkstra.remove();

            if(path[1] > distances[path[0]]) {
                continue;
            }

            ArrayList<int[]> neighbours = adjList.get(path[0]);
            for(int[] neighbour : neighbours) {
                int newDistance = path[1] + neighbour[1];
                if(distances[neighbour[0]] > newDistance) {
                    distances[neighbour[0]] = newDistance;
                    dijkstra.add(new int[] {neighbour[0], newDistance});
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(distances[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, distances[i]);
        }

        return maxDistance;
    }
}