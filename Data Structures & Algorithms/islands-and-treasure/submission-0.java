class Solution {
    public void islandsAndTreasure(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[i].length; j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int currentRow, int currentCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {currentRow, currentCol});
        int level = 1;
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        visited[currentRow][currentCol] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] index = queue.poll();
                int row = index[0];
                int col = index[1];
                
                // row + 1
                if(row + 1 < rooms.length && !visited[row + 1][col] && rooms[row + 1][col] != -1 && rooms[row + 1][col] != 0) {
                    queue.add(new int[]{row + 1, col});
                    visited[row + 1][col] = true;
                    rooms[row + 1][col] = Math.min(level, rooms[row + 1][col]);
                }

                // row - 1
                if(row - 1 >= 0 && !visited[row - 1][col] && rooms[row - 1][col] != -1 && rooms[row - 1][col] != 0) {
                    queue.add(new int[]{row - 1, col});
                    visited[row - 1][col] = true;
                    rooms[row - 1][col] = Math.min(level, rooms[row - 1][col]);
                }

                // col + 1
                if(col + 1 < rooms[0].length && !visited[row][col + 1] && rooms[row][col + 1] != -1 && rooms[row][col + 1] != 0) {
                    queue.add(new int[]{row, col + 1});
                    visited[row][col + 1] = true;
                    rooms[row][col + 1] = Math.min(level, rooms[row][col + 1]);
                }

                // col - 1
                if(col - 1 >= 0 && !visited[row][col - 1] && rooms[row][col - 1] != -1 && rooms[row][col - 1] != 0) {
                    queue.add(new int[]{row, col - 1});
                    visited[row][col - 1] = true;
                    rooms[row][col - 1] = Math.min(level, rooms[row][col - 1]);
                }

            }
            level++;
        }
    }
}