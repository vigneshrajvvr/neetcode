class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adjList = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        int minDistance = 0;

        for(int i = 0; i < points.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j) {
                    continue;
                }
                int distance = Math.abs(points[i][0] - points[j][0]) + 
                               Math.abs(points[i][1] - points[j][1]);
                adjList.get(i).add(new int[] {j, distance});
            }
        }

        PriorityQueue<int[]> minPoints = new PriorityQueue<>(
            (a, b) -> {
                return a[1] - b[1];
            }
        );

        visited.add(0);

        for(int[] neighbour : adjList.get(0)) {
            minPoints.add(neighbour);
        }

        while(!minPoints.isEmpty()) {
            int[] currentNode = minPoints.remove();
            if(visited.contains(currentNode[0])) {
                continue;
            }

            visited.add(currentNode[0]);
            minDistance += currentNode[1];

            for(int[] neighbour : adjList.get(currentNode[0])) {
                if(!visited.contains(neighbour[0])) {
                    minPoints.add(neighbour);
                }
            }
        }

        return minDistance;
    }
}