class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        int[][] neighbourPositions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        minHeap.add(new int[] {grid[0][0], 0, 0});
        HashSet<String> visited = new HashSet<>();
        visited.add("0" + " " + "0");

        while(!minHeap.isEmpty()) {
            int[] currentPosition = minHeap.remove();
            if(currentPosition[1] == grid.length - 1 && currentPosition[2] == grid[0].length - 1) {
                return currentPosition[0];
            }
            for(int[] neighbourPosition : neighbourPositions) {
                int row = currentPosition[1] + neighbourPosition[0];
                int col = currentPosition[2] + neighbourPosition[1];
                if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited.contains(row + " " + col)) {
                    minHeap.add(new int[] {Math.max(currentPosition[0], grid[row][col]), row, col});
                    visited.add(row + " " + col);
                }
            }
        }

        return -1;
    }
}

// while true
//  t = 0 => dfs on the reachable nodes from the current position maintained
// increment t until the target node is visited