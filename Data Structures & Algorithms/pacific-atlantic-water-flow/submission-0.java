class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> bothFlows = new ArrayList<>();
        int row = heights.length;
        int col = heights[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                boolean canReachPacific = canReachOcean(heights, i, j, new boolean[row][col], "pacific");
                boolean canReachAtlantic = canReachOcean(heights, i, j, new boolean[row][col], "atlantic");

                if(canReachPacific && canReachAtlantic) {
                    bothFlows.add(Arrays.asList(i, j));
                }
            }
        }

        return bothFlows;   
    }

    private boolean canReachOcean(int[][] heights, int i, int j, boolean[][] visited, String oceanName) {

        if(oceanName.equals("pacific")) {
            if(i == 0 || j == 0) {
                return true;
            }
        }

        if(oceanName.equals("atlantic")) {
            if(i == heights.length - 1 || j == heights[0].length - 1) {
                return true;
            }
        }

        visited[i][j] = true;
        boolean north = false;
        boolean south = false;
        boolean east = false;
        boolean west = false;

        if(i + 1 <= heights.length - 1 && !visited[i + 1][j] && heights[i][j] >= heights[i + 1][j]) {
         north = canReachOcean(heights, i + 1, j, visited, oceanName);
        }

        if(i - 1 >= 0 && !visited[i - 1][j] && heights[i][j] >= heights[i - 1][j]) {
            south = canReachOcean(heights, i - 1, j, visited, oceanName);
        }

        if(j + 1 <= heights[0].length - 1 && !visited[i][j + 1] && heights[i][j] >= heights[i][j + 1]) {
            east = canReachOcean(heights, i, j + 1, visited, oceanName);
        }

        if(j - 1 >= 0 && !visited[i][j - 1] && heights[i][j] >= heights[i][j - 1]) {
            west = canReachOcean(heights, i, j - 1, visited, oceanName);
        }

        return north || south || east || west;
    }
}