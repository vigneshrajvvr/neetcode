class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0, visited);
            }

            if(board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1, visited);
            }
        }

        for(int j = 0; j < board[0].length; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j, visited);
            }

            if(board[board.length - 1][j] == 'O') {
                dfs(board, board.length - 1, j, visited);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, boolean[][] visited) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        dfs(board, row + 1, col, visited);
        dfs(board, row - 1, col, visited);
        dfs(board, row, col + 1, visited);
        dfs(board, row, col - 1, visited);
    }
}