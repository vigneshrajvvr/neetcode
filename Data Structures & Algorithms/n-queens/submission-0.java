class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> queens = new ArrayList<>();
        List<String> board = new ArrayList<>();
        boolean[] queenColumnIndexes = new boolean[n];
        boolean[] leftDiagonal = new boolean[2 * n];
        boolean[] rightDiagonal = new boolean[2 * n];

        for(int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < n; j++) {
                row.append(".");
            }
            board.add(row.toString());
        }

        solveNQueensHelper(0, n, board, queens, queenColumnIndexes, leftDiagonal, rightDiagonal);

        return queens;
    }

    private void solveNQueensHelper(int row, int n, List<String> board, List<List<String>> queens, boolean[] queenColumnIndexes, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        if(row == n) {
            queens.add(new ArrayList<>(board));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(queenColumnIndexes[i] || leftDiagonal[row - i + n] || rightDiagonal[row + i]){
                continue;
            }
            String currentPosition = board.get(row);
            queenColumnIndexes[i] = true;
            leftDiagonal[row - i + n] = true;
            rightDiagonal[row + i] = true;
            board.set(row, currentPosition.substring(0, i) + "Q" + currentPosition.substring(i + 1, n));
            solveNQueensHelper(row + 1, n, board, queens, queenColumnIndexes, leftDiagonal, rightDiagonal);
            board.set(row, currentPosition);
            queenColumnIndexes[i] = false;
            leftDiagonal[row - i + n] = false;
            rightDiagonal[row + i] = false;
        }
    }

    private boolean isDiagonal(int row, int col, List<String> board) {
        int tempRow = row;
        int tempCol = col;

        while(row > 0 && col > 0) {
            if(board.get(row - 1).charAt(col - 1) == 'Q') {
                return true;
            }
            row--;
            col--;
        }

        while(tempRow > 0 && tempCol < board.size() - 1) {
            if(board.get(tempRow - 1).charAt(tempCol + 1) == 'Q') {
                return true;
            }
            tempRow--;
            tempCol++;
        }

        return false;
    }
}