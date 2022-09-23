class Solution {
    private List<List<String>> result = new LinkedList();
    public List<List<String>> solveNQueens(int n) {
        // init an empty board
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        // start filling the board row by row
        backtrack(board, 0);
        return result;
    }
    
    public void backtrack(char[][] board, int row) {
        int n = board.length;
        // see if reach the end row
        if (row == n) {
            // add the solution           
            result.add(charToString(board));
            // finish a round
            return;
        }
        
        for (int col = 0; col < n; ++col) {
            // if not valid, skip
            if (!isValid(board, row, col)) continue;
            // make selection: place the Q
            board[row][col] = 'Q';
            // traverse to the next row
            backtrack(board, row + 1);
            // withdraw the selction
            board[row][col] = '.';            
        }
    }
    
    public boolean isValid(char[][] board, int row, int col) {
        // check if conflict with completed rows and bound exceeding
        int n = board.length;
        // 1. check upside
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 2. check up-left
        // CAUTION: && 
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 3. check up-right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    
    public List<String> charToString(char[][] board) {
        List<String> solution = new LinkedList();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
    
    
}