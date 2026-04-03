class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxNumIslands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    maxNumIslands = Math.max(maxNumIslands, dfs(grid, i, j));
                }
            }
        }

        return maxNumIslands;
    }

    
    private int dfs(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        int isLandArea = 1;

        isLandArea += dfs(grid, row + 1, col);
        isLandArea += dfs(grid, row - 1, col);
        isLandArea += dfs(grid, row, col + 1);
        isLandArea += dfs(grid, row, col - 1);

        return isLandArea;
    }
}
