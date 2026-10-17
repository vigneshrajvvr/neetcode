class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for(int i = 0; i <= k; i++) {
            int[] intermediateDistance = Arrays.copyOf(distance, n);
            for(int[] currentFlight : flights) {
                int u = currentFlight[0];
                int v = currentFlight[1];
                int w = currentFlight[2];

                if(distance[u] != Integer.MAX_VALUE && distance[u] + w < intermediateDistance[v]) {
                    intermediateDistance[v] = distance[u] + w;
                }
            }

            distance = intermediateDistance;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}