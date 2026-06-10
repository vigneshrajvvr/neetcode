class Solution {

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int minMinutes = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }

                if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) {
            return 0;
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] rottenOrange = queue.remove();
                int row = rottenOrange[0];
                int col = rottenOrange[1];

                // row + 1
                if(row + 1 < grid.length && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.add(new int[] {row + 1, col});
                    freshOranges--;
                }

                // row - 1
                if(row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.add(new int[] {row - 1, col});
                    freshOranges--;
                }

                // col + 1
                if(col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.add(new int[] {row, col + 1});
                    freshOranges--;
                }

                // col - 1
                if(col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.add(new int[] {row, col - 1});
                    freshOranges--;
                }
            }
            minMinutes++;
            if(freshOranges == 0) {
                return minMinutes;
            }
        }

        return freshOranges > 0 ? -1 : minMinutes;
    }
}