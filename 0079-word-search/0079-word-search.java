class Solution {
    boolean[][] used;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // start search from any board[i][j] == word[0]
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = dfs(board, word, i, j, 0);
                    if (flag) return true;
                }
            }
        }
        return false;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length, n = board[0].length;
        // outta bound
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        // visited
        if (used[i][j]) return false;
        // not the target char
        if (board[i][j] != word.charAt(k)) return false;
        // reach the end of the word
        if (board[i][j] == word.charAt(k) && k == word.length() - 1) 
            return true;       
        // traverse
        used[i][j] = true;
        boolean result = false;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];          
            boolean flag = dfs(board, word, x, y, k + 1);
            if (flag) {
                result = true;
                break;
            }
        }
        used[i][j] = false;
        return result;
    }
}