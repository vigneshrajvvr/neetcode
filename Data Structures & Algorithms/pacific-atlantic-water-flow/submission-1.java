class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        HashSet<List<Integer>> pacificVisited = new HashSet<>();
        HashSet<List<Integer>> atlanticVisited = new HashSet<>();
        List<List<Integer>> bothVisited = new ArrayList<>();

        for(int i = 0; i < heights.length; i++) {
            dfs(heights, pacificVisited, i, 0, "pacific");
            dfs(heights, atlanticVisited, i, heights[0].length - 1, "atlantic");
        }

        for(int i = 0; i < heights[0].length; i++) {
            dfs(heights, pacificVisited, 0, i, "pacific");
            dfs(heights, atlanticVisited, heights.length - 1, i, "atlantic");
        }

        for(List<Integer> pacific : pacificVisited) {
            if(atlanticVisited.contains(pacific)) {
                bothVisited.add(pacific);
            }
        }

        return bothVisited;
    }

    private void dfs(int[][] heights, HashSet<List<Integer>> visited, int row, int col, String oceanName) {
        visited.add(Arrays.asList(row, col));

        if(row + 1 < heights.length && !visited.contains(Arrays.asList(row + 1, col)) && heights[row][col] <= heights[row + 1][col]) {
            dfs(heights, visited, row + 1, col, oceanName);
        }

        if(row - 1 >= 0 && !visited.contains(Arrays.asList(row - 1, col)) && heights[row][col] <= heights[row - 1][col]) {
            dfs(heights, visited, row - 1, col, oceanName);
        }

        if(col + 1 < heights[0].length && !visited.contains(Arrays.asList(row, col + 1)) && heights[row][col] <= heights[row][col + 1]) {
            dfs(heights, visited, row, col + 1, oceanName);
        }
        
        if(col - 1 >= 0 && !visited.contains(Arrays.asList(row, col - 1)) && heights[row][col] <= heights[row][col - 1]) {
            dfs(heights, visited, row, col - 1, oceanName);
        }
    }
}