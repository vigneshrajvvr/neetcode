class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> lookup = new HashSet<>();
        int n = board.length;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    String row = i + "row" + board[i][j];
                    String col = j + "col" + board[i][j];
                    String box = i / 3 + "block" + board[i][j] + j / 3;

                    if(!lookup.add(row) || !lookup.add(col) || !lookup.add(box)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
