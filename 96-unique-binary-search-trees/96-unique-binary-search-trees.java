class Solution {
    private int[][] memo;
    
    public int numTrees(int n) {
        // memo[i][j] = count(i, j)
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }
    
    public int count(int lower, int upper) {
        // count the combination # of possible subtrees
        
        // base case
        if (lower > upper) {
            // n = 0
            return 1;
        }
        
        // look up the memo
        if (memo[lower][upper] != 0) {
            return memo[lower][upper];
        }
        
        int result = 0;
        // for each node to be root
        // the count should be the combination sum of its left and right
        for (int i = lower; i <= upper; ++i) {
            int left = count(lower, i - 1);
            int right = count(i + 1, upper);            
            result += left * right;
        }
        
        memo[lower][upper] = result;
        
        return result;
        
        
    }
}