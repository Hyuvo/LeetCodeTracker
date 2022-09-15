class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    
    private boolean backtrack(char[][] board, int row, int col) {
        int m = 9, n = 9;
        // base case: completed the last row
        if (row == m) {
            return true;
        }
        // if exceeds the end of a row
        // move to the start of the next row
        if (col == n) {
            return backtrack(board, row + 1, 0);
        }
        
        // if the grid has a preset digit, skip to the next
        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }
        
        // see every possible solution
        for (char c = '1'; c <= '9'; ++c) {
            // if c is invalid, skip
            if (!isValid(board, row, col, c)) {
                continue;
            }
            board[row][col] = c;
            // return immediately if finds one possible solution
            if (backtrack(board, row, col + 1)) {
                return true;
            }
            // withdraw the decision
            board[row][col] = '.';
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        // check the 3 rules
        
        // as validation is done prior to put the c, no need to skip c
        for (int i = 0; i < 9; ++i) {
            // 1. check the row
            if (board[row][i] == c) return false;
            // 2. check the col
            if (board[i][col] == c) return false;
            // 3. check the sub-box
            if (board[(row/3)*3 + i/3][(col/3)*3 + i%3] == c) return false;
        }
        return true;
    }
}