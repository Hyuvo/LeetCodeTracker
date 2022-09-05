class Solution {
    List<List<String>> result = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        // store chess board with a char[][], representing the position of queen on each row
        char[][] board = new char[n][n];
        // init an empty board
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(board, 0);
        return result;
    }
    
    public void backtrack(char[][] board, int row) {
        // terminate when each row has a queen
        // no -1
        if (row == board.length) {
            // complete one solution, add to the res
            result.add(charToString(board));
            return;
        }
        int n = board[row].length;
        // try each col on current row
        for (int col = 0; col < n; ++col) {
            // see if it would conflict with other queens
            if (!isValid(board, row, col)) {
                // if not eligible, skip
                continue;
            }
            // make choice
            board[row][col] = 'Q';
            // recurse to next row
            backtrack(board, row + 1);
            // cancle choice
            board[row][col] = '.';
        }
        
    }
    
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // check queen on 3 directions
        
        // 1. check each row on this col
        for (int i = 0; i < n; ++i) {
            if (board[i][col] == 'Q') return false;
        }
        // no need to check downwards
        // 2. up-left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q') return false;
        }
        // 3. up-right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
            if (board[i][j] == 'Q') return false;
        }
            
        return true;        
    }
    
    public List<String> charToString(char[][] board) {
        // convert board to result list
        List<String> solution = new LinkedList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        
        return solution;
    }
}